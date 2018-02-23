package engine;

import java.util.Map;

import engine.controllers.LayerController;
import engine.scenarios.ScenarioInitialiser;

public class Application {

	
	public static void main(String[] args){
		
		Application application = createApplication();
		application.run();

	}

	private static Application createApplication() {
		Application application = new Application();
		return application;
	}

	private void run() {
		Controller controller = new Controller();
		
		Map<LayerType, LayerController> layerControllers = controller.initialise();
		
		 Scenario scenario = initialiseScenario();
		
		controller.runScenario(layerControllers, scenario);
	}

	protected Scenario initialiseScenario() {
		ScenarioInitialiser scenarioInitialiser = new ScenarioInitialiser();
		return scenarioInitialiser.initialiseScenario();
	}
	
	
	
	
	
}
