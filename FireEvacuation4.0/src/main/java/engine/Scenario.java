package engine;

import engine.floorplan.FloorPlan;

public class Scenario {

	private final String name;
	private final FloorPlan floorPlan;
	
	
	public Scenario(String name, FloorPlan floorPlan) {
		
		this.name = name;
		this.floorPlan = floorPlan;
	}


	public String getName() {
		return name;
	}


	public FloorPlan getFloorPlan() {
		return floorPlan;
	}
	
	
	
}
