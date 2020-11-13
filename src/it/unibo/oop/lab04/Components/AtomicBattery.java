package it.unibo.oop.lab04.Components;

import it.unibo.oop.lab04.CompRobot.*;;

public class AtomicBattery extends NonCommandableComponent{

	private final String batteryType;
	
	public AtomicBattery(boolean isOn, boolean isConnected, String compName) {
		super(isOn, isConnected, compName);
		this.batteryType = "uranio-239";
	}
	//Getter
	public String getBatteryType() {
		return this.batteryType;
	}
	
	public boolean useAtomicBattery(ComposableRobot robot) {
		if(robot.getBatteryLevel() > halfBattery(robot)) {
			return false;
		}
		robot.recharge();
		return true;
	}
	
	public double halfBattery(ComposableRobot robot) {
		return ComposableRobot.BATTERY_FULL/2;
	}
	
	

}
