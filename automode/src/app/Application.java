package app;

import automode.BatteryObserver;
import automode.LocationObserver;
import automode.MapObserver;
import automode.Observer;
import automode.PathObserver;
import automode.Robot;

/**
 * Model
 * @author Soonyoung Park
 *
 */
public class Application extends Thread{
	private static Application singleton = null;
	private Robot myRobot;
	private Observer batteryCheck = new BatteryObserver();
	private Observer mapScanning = new MapObserver();
	private Observer pathPlanning = new PathObserver();
	private Observer location = new LocationObserver();

	private Application(){
	}

	private Application (Robot robot){
		myRobot = robot;
	}

	synchronized public static Application getInstance(Robot robot){
		if(singleton == null) {
			singleton = new Application(robot);
		}
		return singleton;
	}

	synchronized public static Application getInstance(){
		if(singleton == null) {
			singleton = new Application();
		}
		return singleton;
	}

	public void run() {
		startAutoMode();
	}

	/**
	 * When AutoMode is started
	 * add observers to Robot.
	 */
	public void startAutoMode() {
		myRobot.setOperation(true);
		myRobot.add(batteryCheck);
		myRobot.add(mapScanning);
		myRobot.add(pathPlanning);
		myRobot.add(location);		
	}

	public Robot myRobot() {
		return myRobot;
	}
	
}
