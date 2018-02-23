package engine.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import engine.Context;
import engine.Coordinate;
import engine.Layer;
import engine.LayerType;
import engine.floorplan.FloorPlan;
import engine.floorplan.elements.FloorPlanElement;
import engine.floorplan.elements.Person;


public class PersonLayerController implements LayerController{

	
	private final LayerType type = LayerType.Person;
	
	
	@Override
	public Layer updateLayer(Context context) {
		
		
		//floorplan
		FloorPlan floorPlan = context.getCurrentFloorPlan();
		Layer currentLayer = context.getCurrentFloorPlan().getLayer(type); 
		Layer updatedLayer = new Layer(floorPlan.getWidth(),floorPlan.getHight(), type);
		
		//TODO: change from list to array list
		Map<Integer, ArrayList<Coordinate>> positionMap = new HashMap<Integer, ArrayList<Coordinate>>(); 
		int maxLinearValue = floorPlan.getWidth() * floorPlan.getHight(); 
		for(int i=0; i<maxLinearValue; i++){
			positionMap.put(i,new ArrayList<Coordinate>());
		}
		
		if(context.getTime() != 0){
			
			assessDensityInducedStress(context);
			
			for(int i=0; i<floorPlan.getWidth(); i++){
				for(int j=0; j<floorPlan.getHight(); j++){	
					Coordinate currentPosition = new Coordinate(i,j);
					processPosition(context, currentLayer, currentPosition, positionMap);
				}
			}
			
			postMoveProccessing(floorPlan, updatedLayer, positionMap);
		
			return updatedLayer;
		}
		
		return currentLayer;
	}
	
	
	private Coordinate getClosestExit(Context context, Coordinate position){
		Layer exits = context.getCurrentFloorPlan().getLayer(LayerType.Exit);
		int width = context.getCurrentFloorPlan().getWidth();
		int hight = context.getCurrentFloorPlan().getHight();
		
		double minimumDistanceToExit = 0;
		Coordinate closestExitLocation = null;
		
		boolean firstExit = true;
		
		for(int i=0; i<width; i++){
			for(int j=0; j<hight; j++){
				if(exits.getElement(i, j) != null){
					double xDistance = Math.abs(i - position.getXCoord());
					double yDistance = Math.abs(j - position.getYCoord());
					double distance = Math.sqrt((xDistance*xDistance + yDistance*yDistance));
					
					if(firstExit){
						minimumDistanceToExit = distance; 
						closestExitLocation = new Coordinate(i, j);
						firstExit = false;
					}
					else if(distance < minimumDistanceToExit){
						closestExitLocation = new Coordinate(i,j);
						minimumDistanceToExit = distance;
					}
				}
			}
		}
		return closestExitLocation;
	}


	private void processPosition(Context context, Layer currentLayer, Coordinate currentPosition, Map<Integer, ArrayList<Coordinate>> positionMap) {
		FloorPlan floorPlan = context.getCurrentFloorPlan();
		if(personAtPosition(currentLayer, currentPosition)){
			
			if(stillInPlay(context, currentLayer, currentPosition)) {
				
				if(allowedToMove(context, currentLayer,currentPosition)){
					List<Coordinate> availiableSquares = getAvaliableSquares(currentPosition, context);
					Coordinate newPosition = getNewPosition(context, currentPosition, availiableSquares); //GET NEW POSITION
					submitPositionRequest(floorPlan, positionMap, currentPosition, newPosition);
				}
				else{
					int linear = coordinateToLinear(currentPosition, floorPlan.getWidth());
					positionMap.get(linear).add(currentPosition);
				}
			}
		}
	}


	private void postMoveProccessing(FloorPlan floorPlan, Layer updatedLayer, Map<Integer, ArrayList<Coordinate>> positionMap) {
		for (Map.Entry<Integer, ArrayList<Coordinate>> entry : positionMap.entrySet()){
			
			ArrayList<Coordinate> values = entry.getValue();
			
		    if(!values.isEmpty()){
		    	if(values.size() > 1){
		    		
		    		Random random = new Random();
		    		int successfulPerson = random.nextInt(positionMap.get(entry.getKey()).size());
		    		
		    		int newX = linearToCoordinateX(entry.getKey(), floorPlan.getWidth());
		    		int newY = linearToCoordinateY(entry.getKey(), floorPlan.getWidth());
		    		int oldX = positionMap.get(entry.getKey()).get(successfulPerson).getXCoord();
		    		int oldY = positionMap.get(entry.getKey()).get(successfulPerson).getYCoord();
		    		
					updatedLayer.add(newX, newY, getElement(floorPlan, type, new Coordinate(oldX,oldY)));

		    		
		    		positionMap.get(entry.getKey()).remove(successfulPerson);
		    		
		    		for(int k=0; k<positionMap.get(entry.getKey()).size(); k++){
		    			
			    		int x = positionMap.get(entry.getKey()).get(k).getXCoord();
			    		int y = positionMap.get(entry.getKey()).get(k).getYCoord();
			    		
			    		
			    		updatedLayer.add(x, y, floorPlan.getLayer(type).getElement(x, y));
		    		}
		    	}
		    		
		    	else{
		    		
		    		int newX = linearToCoordinateX(entry.getKey(), floorPlan.getWidth());
		    		int newY = linearToCoordinateY(entry.getKey(), floorPlan.getWidth());
		    		int oldX = positionMap.get(entry.getKey()).get(0).getXCoord();
		    		int oldY = positionMap.get(entry.getKey()).get(0).getYCoord();
		    		
		    		
		    		updatedLayer.add(newX, newY, floorPlan.getLayer(type).getElement(oldX, oldY));
		    		
		    	}
		    }
		}
	}


	private boolean personAtPosition(Layer current, Coordinate position) {
		return current.getElement(position.getXCoord(), position.getYCoord()) != null;
	}


	private boolean stillInPlay(Context context,Layer current, Coordinate position) {
		
		Person temp = (Person) current.getElement(position.getXCoord(), position.getYCoord());
		
		if(checkForExitEncountered(context, position)){
			postExitOpperation(context, current, position);
			context.decreaseStressEscape();
			return false;
		}
		
		if(checkForFireEncountered(context, position, temp)){
			dealWithStressFire(context, temp);
			if(checkForFatality(context, current, position, temp)){
				context.increaseStressFatality();
				return false;
			}
		}
		
		if(checkForSmokeEncountered(context, position, temp)){
			dealWithStressSmoke(context, temp);
			if(checkForFatality(context, current, position, temp)){
				context.increaseStressFatality();
				return false;
			}
		}
		
		
		if(context.getStress() >= 1000){
			temp.decreaseHealthStress();
			if(checkForFatality(context, current, position, temp)){
				context.increaseStressFatality();
				return false;
			}
		}
		
		return true;
	}


	private void dealWithStressSmoke(Context context, Person temp) {
		context.increaseStressSmoke();
	}


	private void dealWithStressFire(Context context, Person temp) {
		context.increaseStressFire();
	}


	
	private boolean checkForSmokeEncountered(Context context, Coordinate position, Person temp) {
		
		FloorPlan floorPlan = context.getCurrentFloorPlan();
		
		if(getElement(floorPlan, LayerType.Smoke, position) != null){
			temp.decreaseHealth10();
			
			return true;
		}
		return false;
	}


	private boolean allowedToMove(Context context, Layer current, Coordinate position) {
		return context.getTime() % ((Person) current.getElement(position.getXCoord(), position.getYCoord())).getSlowness() == 0;
	}

	private void submitPositionRequest(FloorPlan floorPlan,Map<Integer, ArrayList<Coordinate>> positionMap,Coordinate position, Coordinate newPosition) {
		
		if(locationFree(floorPlan, newPosition)){
			int linear = coordinateToLinear(newPosition, floorPlan.getWidth());
			positionMap.get(linear).add(position);
		}
		else{
			int linear = coordinateToLinear(position, floorPlan.getWidth());
			positionMap.get(linear).add(position);
		}
	}

	private List<Coordinate> getAvaliableSquares(Coordinate currentPosition, Context context){
		
		List<Coordinate> availableSquares = new ArrayList<Coordinate>(); 
		FloorPlan floorPlan = context.getCurrentFloorPlan();
		int width = floorPlan.getWidth();
		int hight = floorPlan.getHight();
		int currentX = currentPosition.getXCoord();
		int currentY = currentPosition.getYCoord();
		
		 for(int i=currentX-1; i<currentX+3; i++){
			 for(int j=currentY-1; j<currentY+3; j++){
				 if(i > 0 && j > 0 && i < width && j < hight){
					 for(LayerType type : LayerType.values()){
						 if(floorPlan.getLayer(type).getElement(i, j) == null){
							 availableSquares.add(new Coordinate(i,j));
						 }
					 }
				 }
			 }
		 }
		
		return availableSquares;
	}

	private Coordinate getNewPosition(Context context, Coordinate position, List<Coordinate> availiableSquares) {
		
		Coordinate closestExit = getClosestExit(context, position);
		int xExit = closestExit.getXCoord();
		int yExit = closestExit.getYCoord();
		double minimumDistance = Double.MAX_VALUE; 
		Coordinate closestToExit = null;
		
		for(int i=0; i<availiableSquares.size(); i++){
			
			int xCoord = availiableSquares.get(i).getXCoord();
			int yCoord = availiableSquares.get(i).getYCoord();
			
			double xDistance = Math.abs(xExit - xCoord);
			double yDistance = Math.abs(yExit - yCoord);
			double distance = Math.sqrt(xDistance*xDistance + yDistance*yDistance);
			
			if(distance < minimumDistance){
				minimumDistance = distance;
				closestToExit = availiableSquares.get(i);
			}
		}
		
		return closestToExit;
		
	}


	private boolean locationFree(FloorPlan floorPlan, Coordinate position) {

		return getElement(floorPlan, LayerType.StaticElement, position) == null 
								&& getElement(floorPlan, LayerType.Fire, position) == null 
								&& getElement(floorPlan,LayerType.Person, position) == null;
	}


	private boolean checkForExitEncountered(Context context, Coordinate position) {

		FloorPlan floorPlan = context.getCurrentFloorPlan();
		
		if(getElement(floorPlan, LayerType.Exit, position) != null){
			
			return true;
		}
		return false;
	}


	private void postExitOpperation(Context context, Layer current, Coordinate position) {
		context.incrementSurvivorCount();
		System.out.println("A Person Escaped\n");
		current.clearCell(position.getXCoord(), position.getYCoord());
	}
	
	private boolean checkForFireEncountered(Context context, Coordinate position, Person temp) {
		
		FloorPlan floorPlan = context.getCurrentFloorPlan();
		
		if(getElement(floorPlan, LayerType.Fire, position) != null){

			temp.decreaseHealth50();
			return true;
		}
		return false;
	}


	private boolean checkForFatality(Context context, Layer current, Coordinate position, Person temp) {
		
		if(temp.getHealth() <= 0){
			postDeathOpperations(context, current, position.getXCoord(), position.getYCoord());
			return true;
		}
		else return false;
	}


	private void postDeathOpperations(Context context, Layer current, int x, int y) {
		context.incrementKillCount();
		System.out.println("A Person was killed at (" + x + "," + y + ")\n");
		current.clearCell(x, y); 
	}


	private FloorPlanElement getElement(FloorPlan floorPlan, LayerType layerType, Coordinate position) {
		return floorPlan.getLayer(layerType).getElement(position.getXCoord(), position.getYCoord());
	}	
	
	
	private int coordinateToLinear(Coordinate position, int width){
		return position.getYCoord() * width + position.getXCoord();
	}
	
	private int linearToCoordinateX(int linear, int width){
		return linear % width;
	}
	
	private int linearToCoordinateY(int linear, int width){
		int x = linear % width;
		return (linear - x)/width;
	}
	
	private void assessDensityInducedStress(Context context){

		int currentNumberOfPeople = 0;
		int highestNumberOfPeople = 0;
		
		Layer current = context.getCurrentFloorPlan().getLayer(LayerType.Person);
		
		currentNumberOfPeople = getNumberOfPeopleInQ1(context, current);
		highestNumberOfPeople = Math.max(currentNumberOfPeople, highestNumberOfPeople);
		currentNumberOfPeople = 0;
		
		currentNumberOfPeople = getNumberOfPeopleInQ2(context, current);
		highestNumberOfPeople = Math.max(currentNumberOfPeople, highestNumberOfPeople);
		currentNumberOfPeople = 0;
		
		currentNumberOfPeople = getNumberOfPeopleInQ3(context, current);
		highestNumberOfPeople = Math.max(currentNumberOfPeople, highestNumberOfPeople);
		currentNumberOfPeople = 0;
		
		currentNumberOfPeople = getNumberOfPeopleInQ4(context, current);
		highestNumberOfPeople = Math.max(currentNumberOfPeople, highestNumberOfPeople);
		currentNumberOfPeople = 0;
		
		if(highestNumberOfPeople >= context.getInitialNumberOfPeople()/2){
			context.incressStressDensity();
		}
	}
	
	private int getNumberOfPeopleInQ1(Context context, Layer current){
		
		int floorPlanWidth = context.getCurrentFloorPlan().getWidth();
		int floorPlanHight = context.getCurrentFloorPlan().getHight();
		
		int boxWidth = floorPlanWidth/2;
		int boxHight = floorPlanHight/2;
		
		
		int currentNumberOfPeople = 0;
		
		for(int i=0; i<boxWidth; i++){
			for(int j=0; j<boxHight; j++){
				if(current.getElement(i, j) != null){
					currentNumberOfPeople++;
				}
			}
		}
		return currentNumberOfPeople;
	}
	
	private int getNumberOfPeopleInQ2(Context context, Layer current){
		
		int floorPlanWidth = context.getCurrentFloorPlan().getWidth();
		int floorPlanHight = context.getCurrentFloorPlan().getHight();
		
		int boxWidth = floorPlanWidth/2;
		int boxHight = floorPlanHight/2;
		
		
		int currentNumberOfPeople = 0;
		
		for(int i=boxWidth; i<floorPlanWidth; i++){
			for(int j=0; j<boxHight; j++){
				if(current.getElement(i, j) != null){
					currentNumberOfPeople++;
				}
			}
		}
		return currentNumberOfPeople;
	}

	private int getNumberOfPeopleInQ3(Context context, Layer current){
	
		int floorPlanWidth = context.getCurrentFloorPlan().getWidth();
		int floorPlanHight = context.getCurrentFloorPlan().getHight();
		
		int boxWidth = floorPlanWidth/2;
		int boxHight = floorPlanHight/2;

		
		int currentNumberOfPeople = 0;
		
		for(int i=0; i<boxWidth; i++){
			for(int j=boxHight; j<floorPlanHight; j++){
				if(current.getElement(i, j) != null){
					currentNumberOfPeople++;
				}
			}
		}
		return currentNumberOfPeople;
	}

	private int getNumberOfPeopleInQ4(Context context, Layer current){
	
		int floorPlanWidth = context.getCurrentFloorPlan().getWidth();
		int floorPlanHight = context.getCurrentFloorPlan().getHight();
		
		int boxWidth = floorPlanWidth/2;
		int boxHight = floorPlanHight/2;

		
		int currentNumberOfPeople = 0;
		
		for(int i=boxWidth; i<floorPlanWidth; i++){
			for(int j=boxHight; j<floorPlanHight; j++){
				if(current.getElement(i, j) != null){
					currentNumberOfPeople++;
				}
			}
		}
		return currentNumberOfPeople;
	}
}



