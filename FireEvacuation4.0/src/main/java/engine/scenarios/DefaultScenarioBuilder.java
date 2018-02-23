package engine.scenarios;

import java.util.ArrayList;
import java.util.List;

import engine.Layer;
import engine.LayerType;
import engine.Scenario;
import engine.floorplan.FloorPlan;
import engine.floorplan.elements.Exit;
import engine.floorplan.elements.FireSource;
import engine.floorplan.elements.Person;
import engine.floorplan.elements.SmokeSource;
import engine.floorplan.elements.Wall;

public class DefaultScenarioBuilder implements ScenarioBuilder {

	@Override	
	public Scenario initialiseScenario() {
		List<Layer> layers = new ArrayList<Layer>();
		int width = 10; //maybe give this info to context? 
		int hight = 10; //maybe give this info to context? 
		
		for(LayerType type : LayerType.values()){
			layers.add(new Layer(width,hight,type));
		}		
		FloorPlan floorPlan = new FloorPlan(layers, width, hight);
		floorPlan.getLayer(LayerType.Wall).add(0, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(1, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(2, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(3, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(4, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(5, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(6, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(7, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(8, 4, new Wall());
		floorPlan.getLayer(LayerType.Wall).add(9, 4, new Wall());
		floorPlan.getLayer(LayerType.Exit).add(0, 3, new Exit());
		floorPlan.getLayer(LayerType.Exit).add(3, 3, new Exit());
		//current.getLayer(LayerType.StaticElement).add(7, 7, new StaticElement());
		//current.getLayer(LayerType.StaticElement).add(6, 4, new StaticElement());
		floorPlan.getLayer(LayerType.Fire).add(0,0, new FireSource(1000000000));
		floorPlan.getLayer(LayerType.Smoke).add(0, 0, new SmokeSource(2));
		floorPlan.getLayer(LayerType.Person).add(1, 1, new Person(1));
		floorPlan.getLayer(LayerType.Person).add(0, 1, new Person(1));
		
		return new Scenario("TestScenario", floorPlan);
	}
	
}
