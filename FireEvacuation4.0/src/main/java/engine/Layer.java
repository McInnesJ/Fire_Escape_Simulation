package engine;

import engine.floorplan.elements.FloorPlanElement;

public class Layer {
	
	private FloorPlanElement[][] layer; 
	private final LayerType type;
	
	public Layer(int width, int hight, LayerType type){
		this.layer = new FloorPlanElement[width][hight];
		this.type = type;
	}
	
	public void add(int x, int y, FloorPlanElement element){
		this.layer[x][y] = element;
	}

	public FloorPlanElement getElement(int x, int y){
		return this.layer[x][y];
	}
	
	public LayerType getType(){
		return this.type;
	}
	
	public void clearCell(int x, int y){
		this.layer[x][y] = null;
	}

}
