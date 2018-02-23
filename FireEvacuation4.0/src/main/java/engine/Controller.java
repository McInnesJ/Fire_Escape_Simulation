package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import engine.controllers.ExitLayerController;
import engine.controllers.FireLayerController;
import engine.controllers.LayerController;
import engine.controllers.PersonLayerController;
import engine.controllers.SmokeLayerController;
import engine.controllers.StaticElementLayerController;
import engine.controllers.WallLayerController;
import engine.floorplan.FloorPlan;
import engine.floorplan.elements.Exit;
import engine.floorplan.elements.FireSource;
import engine.floorplan.elements.Person;
import engine.floorplan.elements.SmokeSource;
import engine.scenarios.ScenarioBuilder;

public class Controller {
	

	public void runScenario(Map<LayerType, LayerController> layerControllers, Scenario scenario) {
		
		FloorPlan floorPlan = scenario.getFloorPlan();
		Context context = initialiseContext(floorPlan);  
		
		boolean run = true;
		while(run){
			
			printCycleInformation(context);
			List<Layer> nextLayers = new ArrayList<Layer>();
			
			for(LayerType type : LayerType.values()){
				nextLayers.add(layerControllers.get(type).updateLayer(context));
			}
			
			
			FloorPlan next = new FloorPlan(nextLayers, context.getCurrentFloorPlan().getWidth(), context.getCurrentFloorPlan().getHight());
			
			
			for(LayerType type : LayerType.values()){
				for(int i=0; i<context.getCurrentFloorPlan().getWidth(); i++){
					for(int j=0; j<context.getCurrentFloorPlan().getHight(); j++){
						if(next.getLayer(type).getElement(i, j) != null){
							//System.out.println(type + " at (" + i + "," + j + ")");
						}
					}
				}
			}
		
			context.updateTime();
			context.updateCurrentFloorPlan(next);
			
			
			if(context.getKillCount() + context.getSurvivorCount() == context.getInitialNumberOfPeople()){
				run = false;
				printResults(context);
			}
			
		}
	}

	private void printCycleInformation(Context context) {
		System.out.println("\nTime: " + context.getTime());
		System.out.println("Stress Level: " + context.getStress() + "\n");
	}

	private void printResults(Context context) {
		System.out.println("\nKILL COUNT: " + context.getKillCount());
		System.out.println("SURVIVOR COUNT: " + context.getSurvivorCount());
		System.out.println("TIME ELAPSED: " + context.getTime());
	}

	private Context initialiseContext(FloorPlan current) {
		int width = current.getWidth();
		int hight = current.getHight();
		
		int exitX = 0;
		int exitY = 0;

		for(int i=0; i<width; i++){
			for(int j=0; j<hight; j++){
				if(current.getLayer(LayerType.Exit).getElement(i, j) != null){
					exitX = i;
					exitY = j;
				}
			}
		}
		Context context = new Context(0, getNumberOfPeople(current), current, exitX, exitY); //note 0,0. an exit should always be added so this should not be returned
		
		return context;
	}

	private int getNumberOfPeople(FloorPlan current){
		int width = current.getWidth();
		int hight = current.getHight();
		
		int numberOfPeople = 0;

		for(int i=0; i<width; i++){
			for(int j=0; j<hight; j++){
				if(current.getLayer(LayerType.Person).getElement(i, j) != null){
					numberOfPeople++;
				}
			}
		}
		return numberOfPeople;
	}

	public Map<LayerType, LayerController> initialise() {
		Map<LayerType, LayerController> layerControllers = new HashMap<LayerType, LayerController>();
		
		layerControllers.put(LayerType.Wall, new WallLayerController());
		layerControllers.put(LayerType.Exit, new ExitLayerController());
		layerControllers.put(LayerType.StaticElement, new StaticElementLayerController());
		layerControllers.put(LayerType.Fire, new FireLayerController());
		layerControllers.put(LayerType.Smoke, new SmokeLayerController());
		layerControllers.put(LayerType.Person, new PersonLayerController());
		
		return layerControllers;
	}
}
