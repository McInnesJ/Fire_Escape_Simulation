package engine.controllers;

import engine.Context;
import engine.Layer;
import engine.LayerType;

public class WallLayerController implements LayerController{

	private final LayerType type = LayerType.Wall;
	
	@Override
	public Layer updateLayer(Context context){
		
		return context.getCurrentFloorPlan().getLayer(type);
	}
}
