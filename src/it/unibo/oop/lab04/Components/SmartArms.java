
package it.unibo.oop.lab04.Components;

import it.unibo.oop.lab04.CompRobot.ComposableRobot;



public class SmartArms extends CommandableComponent{

	private boolean pick;
	private boolean drop;
	private final ComposableRobot robot;
	
	public SmartArms(final boolean isOn, final boolean isConnected, final String compName, final ComposableRobot robot) {
		super(isOn, isConnected, compName);
		this.robot = robot;
		this.pick = false;
		this.drop = false;
	}

	public void doSmartPick() {
		this.drop = false;
		if (robot.getCarriedItemsCount() == 0) {
			robot.pickUp();
			this.pick = true;
		}
	}
	
	public void doSmartDrop() {
		this.pick = false;
		if(robot.getCarriedItemsCount() == 1) {
			robot.dropDown();
			this.drop= true;
		}
	}
	
	public String toString() {
		return "SmartArms [pick=" + pick + ", drop=" + drop + ", robot=" + robot + "]";
	}
	
}
