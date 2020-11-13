package it.unibo.oop.lab04.CompRobot;

import it.unibo.oop.lab04.robot.arms.RobotWithTwoArms;
import it.unibo.oop.lab04.robot.base.*;

public class ComposableRobot extends RobotWithTwoArms{

	private RobotPosition pos;
	private RobotEnvironment env;
	
	public ComposableRobot(String robotName,RobotEnvironment env) {
		super(robotName);
		this.env = env;
	}

	public RobotEnvironment getEnv() {
		return this.env;
	}

	public void setEnv(RobotEnvironment env) {
		this.env = env;
	}

	public RobotPosition getPos() {
		return this.pos;
	}

	public void setPos(RobotPosition pos) {
		this.pos = pos;
	}

}
