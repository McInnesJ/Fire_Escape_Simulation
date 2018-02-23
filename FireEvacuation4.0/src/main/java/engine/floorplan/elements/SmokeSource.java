package engine.floorplan.elements;

public class SmokeSource implements FloorPlanElement{

	private int slowness; //if slowness is n then the fire moves every nth cycle
	
	public SmokeSource(int slowness){
		this.slowness = slowness;
	}
	
	public int getSlowness(){
		return this.slowness;
	}
	
}
