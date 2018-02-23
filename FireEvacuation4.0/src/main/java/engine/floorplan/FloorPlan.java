package engine.floorplan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import engine.Layer;
import engine.LayerType;
import engine.floorplan.elements.FloorPlanElement;

public class FloorPlan {
	
	private final Map<LayerType,Layer> layers = new HashMap<LayerType,Layer>();
	private final int width;
	private final int hight; 
	
	
	public FloorPlan(List<Layer> layers, int width, int hight){
		for(int i=0; i<layers.size(); i++){
			this.layers.put(layers.get(i).getType(), layers.get(i));
		}
		this.width = width;
		this.hight = hight;
		
	}
	
	public int getWidth(){
		return this.width;
	}
	public int getHight(){
		return this.hight;
	}
	
	public Layer getLayer(LayerType type){
		return this.layers.get(type);
	}

	
	
	@Deprecated
	public void addLayer(Layer layer, LayerType type){
		this.layers.put(type, layer);
		//TODO: ensure layer added is correct size
	}

	@Deprecated
	public boolean checkForConflict(int x, int y){
		
		int numberOfElementsOnSquare = 0; 
		
		for(LayerType type : LayerType.values()){
			if(this.layers.get(type).getElement(x, y) != null){
				numberOfElementsOnSquare++;
			}
		}
		if(numberOfElementsOnSquare > 1){
			return true;
		}
		else return false; 
	}
	
	@Deprecated
	public FloorPlanElement[] getSquare(int x, int y){
		FloorPlanElement[] square = new FloorPlanElement[5];
		int i = 0;
		
		for(LayerType type : LayerType.values()){
			square[i] = this.layers.get(type).getElement(x, y);
		}
		
		return square;
	}
	
}
