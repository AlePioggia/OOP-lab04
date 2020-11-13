
package it.unibo.oop.lab04.Components;

public abstract class Component {
	
	private static final double STANDARD_CONSUME = 0.25;
	private boolean isComponentOn;
	private boolean isComponentConnected;
	private boolean isComponentCommandable;
	private double batteryConsume;
	private String componentName;
	
	public Component(boolean isOn, boolean isConnected, boolean isCommandable,String compName) {
		this.isComponentOn = isOn;
		this.isComponentConnected = isConnected;
		this.isComponentCommandable = isCommandable;
		this.batteryConsume = STANDARD_CONSUME;
		this.setComponentName(compName);
	}
	
	public Component(boolean isOn, boolean isConnected,String compName) {
		this.isComponentOn = isOn;
		this.isComponentConnected = isConnected;
		this.batteryConsume = STANDARD_CONSUME;
		this.setComponentName(compName);
	}
	
	//Getters
	public static double getStandardConsume() {
		return STANDARD_CONSUME;
	}
	
	public boolean isComponentOn() {
		return this.isComponentOn;
	}
	
	public boolean isComponentConnected() {
		return this.isComponentConnected;
	}
	
	public double getBatteryConsume() {
		return this.batteryConsume;
	}
	
	public String getComponentName() {
		return this.componentName;
	}
	
	public boolean isComponentCommandable() {
		return this.isComponentCommandable;
	}
	
	//Setters
	public void setComponentOn(boolean isComponentOn) {
		this.isComponentOn = isComponentOn;
	}
	
	public void setComponentConnected(boolean isComponentConnected) {
		this.isComponentConnected = isComponentConnected;
	}
	
	public void setBatteryConsume(double batteryConsume) {
		this.batteryConsume = batteryConsume;
	}

	public void setComponentCommandable(boolean isComponentComandable) {
		this.isComponentCommandable = isComponentComandable;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
	
	
	
}
