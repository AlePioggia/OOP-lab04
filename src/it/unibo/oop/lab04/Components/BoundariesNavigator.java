
package it.unibo.oop.lab04.Components;

import it.unibo.oop.lab04.CompRobot.*;
import it.unibo.oop.lab04.robot.base.RobotEnvironment;
import it.unibo.oop.lab04.robot.base.RobotPosition;

public class BoundariesNavigator extends NonCommandableComponent{

	public static double LOW_BATTERY = 30;
	private boolean isSecondLap;
	private boolean isDoneExploration;
	
	public BoundariesNavigator(boolean isOn, boolean isConnected, String compName) {
		super(isOn, isConnected, compName);
		this.isSecondLap = false;
		this.isDoneExploration = false;
	}

	public void useBoundariesNavigator(ComposableRobot robot,RobotEnvironment env,RobotPosition pos) {
		//Lo faccio ripartire dall'origine per poi fargli visitare i boundaries
		
		robot.setPos(pos);
		robot.setEnv(env);;
		System.out.println(robot.getPos());
		var startingPos = robot.getPos();
		
		do {
			while(robot.moveUp()) {
				isExplorationOver(robot, startingPos);
				lowBatteryCheck(robot);
			}
			while(robot.moveRight()) {
				isExplorationOver(robot, startingPos);
				lowBatteryCheck(robot);
			}
			while(robot.moveDown()) {
				isExplorationOver(robot, startingPos);
				lowBatteryCheck(robot);
			}
			while(robot.moveLeft()) {
				isExplorationOver(robot, startingPos);
				lowBatteryCheck(robot);
			}
			this.isSecondLap = true;
	}while(!isDoneExploration);
	
}
	
	private void isExplorationOver(ComposableRobot robot, RobotPosition startingPos) {
		if(positionCheck(robot, startingPos)) {
			isDoneExploration=true;
		}
	}
	
	private boolean positionCheck(ComposableRobot robot,RobotPosition startPos) {
		if(isSecondLapCheck()) {
			return robot.getPos() == startPos;
		}
		return false;
	}
	
	private boolean isSecondLapCheck() {
		return this.isSecondLap;
	}
	
	private void lowBatteryCheck(ComposableRobot robot) {
		if(robot.getBatteryLevel() < LOW_BATTERY) {
			robot.recharge();
		}
	}
	
	public void printString(ComposableRobot robot) {
		System.out.println("ROBOT IS HERE" + robot.getPos());
	}
	
}

