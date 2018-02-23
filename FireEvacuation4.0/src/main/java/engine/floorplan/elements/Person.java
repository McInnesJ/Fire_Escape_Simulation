package engine.floorplan.elements;

import java.util.Random;

public class Person implements FloorPlanElement{

	private int slowness;
	private boolean firstSmokeEncounter = true;
	private int health = 100; 
	@Deprecated
	private boolean alive = true;

	public Person(int slowness) {
		this.slowness = slowness;
	}
	
	
	public int getSlowness() {
		return slowness;
	}
	
	@Deprecated
	public void kill(){
		this.alive = false;
	}

	@Deprecated
	public void increaseSlownessSmoke(){
		if(firstSmokeEncounter){
			slowness *= 2; 
			firstSmokeEncounter = false;
		}
	}
	
	public void decreaseHealth10(){
		//10 percent reduction in health
		health -= 10;
		healthAdjustedSlowness(health);
	}
	
	public void decreaseHealth50(){
		//50 percent reduction in health
		health -= 50;
		healthAdjustedSlowness(health);
	}
	
	public void decreaseHealthStress(){
		
		Random rand = new Random();
		int healthLost = rand.nextInt(25);
		
		health -= healthLost;

	}
	
	public int getHealth(){
		return health;
	}
	
	private void healthAdjustedSlowness(int health){
		
		float percentageIncrease = (100 - health)/100;
		int increase = Math.round(slowness*percentageIncrease);
		slowness += increase;
		
	}
}
