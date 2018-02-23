package engine;

public enum LayerType {

	//Note, when adding new types they must also be added manually in the initialise functio on the controller class (Controller.initialise()).
	
	Wall,
	
	Exit,

	StaticElement,
	
	Fire,
	
	Smoke,
	
	Person
	;
}
