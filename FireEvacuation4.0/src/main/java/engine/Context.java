package engine;

import engine.floorplan.FloorPlan;

public class Context {

	private int time;
	private FloorPlan current;
	private int initialNumberOfPeople;
	private int survivorCount;
	private int killCount;
	private int stress = 0; 
	
	
	public Context(int time, int initialNumberOfPeople, FloorPlan floorPlan, int exitXCoord, int exitYCoord){
		this.time = time;
		this.initialNumberOfPeople = initialNumberOfPeople;
		this.current = floorPlan;
	}
	
	
	public int getStress(){
		return this.stress;
	}
	public void increaseStressSmoke(){
		this.stress++;
	}
	public void increaseStressFire(){
		this.stress += 5;
	}
	public void increaseStressFatality(){
		this.stress += 10;
	}
	public void decreaseStressEscape(){
		if (this.stress > 1){
			this.stress--;
		}
	}
	public void incressStressDensity(){
		this.stress += 2; 
	}
	
	public int getInitialNumberOfPeople() {
		return initialNumberOfPeople;
	}

	public int getSurvivorCount() {
		return survivorCount;
	}
	
	public int getKillCount() {
		return killCount;
	}
	
	public int getTime(){
		return this.time;
	}
	
	public FloorPlan getCurrentFloorPlan(){
		return this.current; 
	}
	
	
	
	public void updateTime(){
		this.time++;
	}
	
	public void updateCurrentFloorPlan(FloorPlan floorPlan){
		this.current = floorPlan;
	}
	
	public void incrementKillCount(){
		this.killCount++;
	}
	
	public void incrementSurvivorCount(){
		this.survivorCount++;
	}
}
