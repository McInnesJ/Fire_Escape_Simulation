package engine.controllers;

import engine.Context;
import engine.Layer;
import engine.LayerType;


public class ExitLayerController implements LayerController {

	private final LayerType type = LayerType.Exit;
	
	@Override
	public Layer updateLayer(Context context){
		
		return context.getCurrentFloorPlan().getLayer(type);
	}

}
