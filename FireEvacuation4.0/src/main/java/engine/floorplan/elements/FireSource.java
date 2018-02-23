package engine.floorplan.elements;

public class FireSource extends Fire {
	 
	private int slowness; //if slowness is n then the fire moves every nth cycle
	
	public FireSource(int slowness){
		this.slowness = slowness;
	}
	
	public int getSlowness(){
		return this.slowness;
	}
	
	

}
