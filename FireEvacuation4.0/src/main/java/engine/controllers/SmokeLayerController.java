package engine.controllers;

import engine.Context;
import engine.Layer;
import engine.LayerType;
import engine.floorplan.elements.Fire;
import engine.floorplan.elements.SmokeSource;


public class SmokeLayerController implements LayerController {

	private final LayerType type = LayerType.Smoke;
	private boolean run = false;
	private int xCoordOfSource;
	private int yCoordOfSource;
	private int slowness;
	private int radiusOfSmoke = 1;
	
	@Override
	public Layer updateLayer(Context context) {
		
		Layer next = new Layer(context.getCurrentFloorPlan().getWidth(),context.getCurrentFloorPlan().getHight(), type);
		//Layer next = context.getCurrentFloorPlan().getLayer(type); 
		
		if(context.getTime() != 0){
		
			if(!run){
				findSource(context);
			}
			if(context.getTime() % slowness == 0){
				radiusOfSmoke++;
		
				for(int i=0; i<context.getCurrentFloorPlan().getWidth(); i++){
					for(int j=0; j<context.getCurrentFloorPlan().getHight(); j++){
						if(i <= (xCoordOfSource + radiusOfSmoke) 
								&& i >= (xCoordOfSource - radiusOfSmoke) 
								&& j <= (yCoordOfSource + radiusOfSmoke) 
								&& j >= (yCoordOfSource - radiusOfSmoke)){
							
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
					this.slowness = ((SmokeSource) temp.getElement(i, j)).getSlowness();
				}
			}
		}
		
		this.run = true;
	}
	

}
