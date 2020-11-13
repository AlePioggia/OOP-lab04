package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;


public class RobotWithTwoArms extends BaseRobot implements RobotWithArms{

	private final static double MOVE_CONS = 0.1;
	
	private final BasicArm left;
	private final BasicArm right;
	private final String dx = "Left Arm";
	private final String sx = "Right Arm";
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
		this.left = new BasicArm(dx);
		this.right = new BasicArm(sx);
	}

	public boolean pickUp() {
		if(right.isGrabbing() && left.isGrabbing()) {
			return false;
		}
		else if(right.isGrabbing() && isBatteryEnough(left.getConsuptionForPickUp())) {
			this.left.pickUp();
			consumeBattery(left.getConsuptionForPickUp());
			return true;
		}
		else if(isBatteryEnough(right.getConsuptionForPickUp())){
			this.right.pickUp();
			consumeBattery(right.getConsuptionForPickUp());
			return true;
		}
		return false;
	}

	public boolean dropDown() {
		if (this.left.isGrabbing() && this.right.isGrabbing() && 
				isBatteryEnough(right.getConsumptionForDropDown())) {
			consumeBattery(right.getConsumptionForDropDown());
			this.right.dropDown();
			return true;
		}
		else if(this.left.isGrabbing() && isBatteryEnough(left.getConsumptionForDropDown())) {
			consumeBattery(left.getConsumptionForDropDown());
			this.left.dropDown();
			return true;
		}
		else if(this.right.isGrabbing() && isBatteryEnough(right.getConsumptionForDropDown())) {
			consumeBattery(right.getConsumptionForDropDown());
			this.right.dropDown();
			return true;
		}
		return false;
	}

	//Took from solutions
	public int getCarriedItemsCount() {
        return (left.isGrabbing() ? 1 : 0) + (right.isGrabbing() ? 1 : 0);
    }

    protected double getBatteryRequirementForMovement() {
        return super.getBatteryRequirementForMovement() + getCarriedItemsCount() * MOVE_CONS;
    }
}
