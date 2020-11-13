package it.unibo.oop.lab04.robot.test;

import it.unibo.oop.lab04.CompRobot.ComposableRobot;
import it.unibo.oop.lab04.robot.base.RobotEnvironment;
import it.unibo.oop.lab04.robot.base.RobotPosition;
import it.unibo.oop.lab04.Components.*;

/**
 * Utility class for testing composable robots
 * 
 */
public final class TestComposableRobot {

    private TestComposableRobot() {
    }

    public static void main(final String[] args) {

    	RobotPosition pos = new RobotPosition(0,10);
    	RobotEnvironment env = new RobotEnvironment(pos);
        ComposableRobot kawhi = new ComposableRobot("kawhi leonard", env);
        //ATOMIC BATTERY
        System.out.println("Checking atomic battery : ");
        System.out.println(kawhi.getBatteryLevel());
        kawhi.consumeBattery(60);
        System.out.println(kawhi.getBatteryLevel());
        AtomicBattery battery = new AtomicBattery(true, true, "POWERFUL BATTERY");
        battery.useAtomicBattery(kawhi);
        System.out.println(kawhi.getBatteryLevel());
        //PICK AND DROP
        
        SmartArms smartArms = new SmartArms(true, true, "sArm", kawhi);
        System.out.println(smartArms);
        kawhi.pickUp();
        System.out.println(kawhi.getCarriedItemsCount());
        //Should be successful
        smartArms.doSmartDrop();
        System.out.println(smartArms.toString());
        //This should be 0
        System.out.println(kawhi.getCarriedItemsCount());
        //Now pick test
        smartArms.doSmartPick();
        //PICK : true
        System.out.println(smartArms.toString());
        //this should be 1
        System.out.println(kawhi.getCarriedItemsCount());
        
        //Boundaries Navigator
        System.out.println("Checking boundaries navigator : ");
        BoundariesNavigator nav = new BoundariesNavigator(true, true, "EXPLORING TILL KAWHI REACHES THE BOUNDARIES");
        nav.useBoundariesNavigator(kawhi,env,pos);
        
        
    }
}
