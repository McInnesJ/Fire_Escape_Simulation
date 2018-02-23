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

public class Stress implements ScenarioBuilder {

	@Override	
	public Scenario initialiseScenario() {
		List<Layer> layers = new ArrayList<Layer>();
		int width = 50; //maybe give this info to context? 
		int hight = 50; //maybe give this info to context? 
		
		for(LayerType type : LayerType.values()){
			layers.add(new Layer(width,hight,type));
		}		
		FloorPlan floorPlan = new FloorPlan(layers, width, hight);

		//current.getLayer(LayerType.StaticElement).add(7, 7, new StaticElement());
		//current.getLayer(LayerType.StaticElement).add(6, 4, new StaticElement());
		floorPlan.getLayer(LayerType.Fire).add(0,25, new FireSource(20));
		floorPlan.getLayer(LayerType.Smoke).add(0, 0, new SmokeSource(20));
		floorPlan.getLayer(LayerType.Exit).add(49,25, new Exit());
		
		floorPlan.getLayer(LayerType.Person).add(17, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(17, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(18, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(18, 33, new Person(10));
		
		floorPlan.getLayer(LayerType.Person).add(19, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(19, 33, new Person(10));
	
		floorPlan.getLayer(LayerType.Person).add(20, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(20, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(21, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(21, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(22, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(22, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(23, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(23, 33, new Person(10));
		
		floorPlan.getLayer(LayerType.Person).add(24, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(24, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(25, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(25, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(26, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(26, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(27, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(27, 33, new Person(10));

		floorPlan.getLayer(LayerType.Person).add(28, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(28, 33, new Person(10));
			
		floorPlan.getLayer(LayerType.Person).add(29, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(29, 33, new Person(10));
		
		floorPlan.getLayer(LayerType.Person).add(30, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(30, 33, new Person(10));
		
		floorPlan.getLayer(LayerType.Person).add(31, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(31, 33, new Person(10));
		
		floorPlan.getLayer(LayerType.Person).add(32, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(32, 33, new Person(10));
	
		floorPlan.getLayer(LayerType.Person).add(33, 17, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 18, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 19, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 20, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 21, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 22, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 23, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 24, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 25, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 26, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 27, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 28, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 29, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 30, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 31, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 32, new Person(10));
		floorPlan.getLayer(LayerType.Person).add(33, 33, new Person(10));
		
		return new Scenario("TestScenario", floorPlan);
	}
	
}
