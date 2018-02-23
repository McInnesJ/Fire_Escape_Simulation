package engine.scenarios;

import engine.Scenario;

public class ScenarioInitialiser {

	public Scenario initialiseScenario() {
		ScenarioBuilder builder = new Stress();
		return builder.initialiseScenario();
	}
}
