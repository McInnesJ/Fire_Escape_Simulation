package engine.controllers;

import engine.Context;
import engine.Layer;
import engine.LayerType;
import engine.floorplan.elements.Fire;
import engine.floorplan.elements.FireSource;


public class FireLayerController implements LayerController{
	
	private final LayerType type = LayerType.Fire;
	private boolean run = false;
	private int xCoordOfSource;
	private int yCoordOfSource;
	private int slowness;
	private int radiusOfFire = 1;
	
	@Override
	public Layer updateLayer(Context context) {
		
		Layer next = new Layer(context.getCurrentFloorPlan().getWidth(),context.getCurrentFloorPlan().getHight(), type);
		//Layer next = context.getCurrentFloorPlan().getLayer(type);
	
		if(context.getTime() != 0){
		
			if(!run){
				findSource(context);
			}
			if(context.getTime() % slowness == 0){
				radiusOfFire++;
		
				for(int i=0; i<context.getCurrentFloorPlan().getWidth(); i++){
					for(int j=0; j<context.getCurrentFloorPlan().getHight(); j++){
						if(i <= (xCoordOfSource + radiusOfFire) 
								&& i >= (xCoordOfSource - radiusOfFire) 
								&& j <= (yCoordOfSource + radiusOfFire) 
								&& j >= (yCoordOfSource - radiusOfFire)){
							next.add(i, j, new Fire());
						}		
					}
				}
				
				return next;
			}
		}
		
		return context.getCurrentFloorPlan().getLayer(type);
	}
		
		
	
	
	private void findSource(Context context){
		Layer temp = context.getCurrentFloorPlan().getLayer(type);
		
		//used casts - will improve once get and give info methods implemented.
		
		for(int i=0; i<context.getCurrentFloorPlan().getWidth(); i++){
			for(int j=0; j<context.getCurrentFloorPlan().getHight(); j++){
				if(temp.getElement(i, j) != null){
					this.xCoordOfSource = i;
					this.yCoordOfSource = j;
					this.slowness = ((FireSource) temp.getElement(i, j)).getSlowness();
				}
			}
		}
		
		this.run = true;
	}

}
