package it.unibo.oop.lab04.robot.arms;

public class BasicArm {

    private static final double MOVE_ENERGY = 0.2;
    private static final double GRAB_ENERGY = 0.1;
	
	private final String armName;
	private  boolean grab;
	
	public BasicArm(String arm) {
		this.armName = arm;
		this.grab = false;
	}
	
	public boolean isGrabbing() {
		return this.grab;
	}
	
	public void pickUp() {
		this.grab = true;
	}
	
	public void dropDown() {
		this.grab = false;
	}
	
	public double getConsuptionForPickUp() {
		return MOVE_ENERGY + GRAB_ENERGY;
	}
	
	public double getConsumptionForDropDown() {
		return MOVE_ENERGY;
	}
	
	public String toString() {
		return "BasicArm [armName=" + armName + ", grab=" + grab + "]";
	}
	
}
