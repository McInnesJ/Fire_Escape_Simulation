READ ME

Create scenarios to be tested by creating a new class that implements the ScenarioBuilder interface.

The new class will have 1 method on it by default. Use this method to set up the floor plan for the test.

	List<Layer> layers = new ArrayList<Layer>();
		int width = 4; //maybe give this info to context? 
		int hight = 4; //maybe give this info to context? 
		
		for(LayerType type : LayerType.values()){
			layers.add(new Layer(width,hight,type));
		}
		FloorPlan floorPlan = new FloorPlan(layers, width, hight);
		
This block of code sets up the size each layer on the floor plan and the floor plan itself, it should be copy and pasted in every 
time but the width and hight can be altered. 

To add something to the floor plan;

	floorPlan.getLayer(LayerType.type).add(x,y, new Object(parameters))
	
The 'type' after LayerType. has 5 allowed values; Exit, StaticElement, Fire, Smoke, Person. Each layer type will only contain objects of its own type, i.e. fire for the Fire layer, Exits for the exit layer, etc. 

‘x’ and ‘y’ are the coordinates where the object will be added to the floor plan.


Object can be either an 
- Exit, which has no parameters,
- A StaticElement, which has no parameters,
- A FireSource, which has 1 parameter, slowness. i.e. if you pass in a value n it will move every nth time cycle.
- A SmokeSource, which has 1 parameter, slowness.
- A person, which has 1 parameter, slowness. 


Once the floor plan is set up it should be saved. Next open ScenarioInitialiser. See the following line of code;

	ScenarioBuilder builder = new DefaultScenarioBuilder();

Here, simply replace DefaultScenarioBuilder() with the scenario builder just defined. 

Once this has been saved the program is ready to run. This can be done from the Application file. Results will be printed in the console. 
