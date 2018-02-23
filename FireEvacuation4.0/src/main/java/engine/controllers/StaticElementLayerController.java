package engine.controllers;

import engine.Context;
import engine.Layer;
import engine.LayerType;


public class StaticElementLayerController implements LayerController {
	
	private final LayerType type = LayerType.StaticElement;

	@Override
	public Layer updateLayer(Context context) {
		
		return context.getCurrentFloorPlan().getLayer(type);
	}

}
