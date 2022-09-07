package automode;

import java.awt.Point;

/**
 * subject of Observer
 * @author Soonyoung Park
 *
 */

public class Robot extends Subject implements Runnable{

	private static int batteryLevel = 100; //The initial batteryLevel
	private final int minBatteryLevel = 10;
	private boolean operation = false;
	private boolean obstacleDetected = false;
	private boolean wallDetected = false;
	private boolean showBattery = false;
	private Point position;
	private Point chargingDock = new Point(44, 470);
	private boolean pause = false;
	private boolean moveRobot = true;
	private boolean printOnce = true;

	/**
	 * Precondition:
	 * The robot is authorized and connected to the APP via local WIFI.
	 * The robot is at the charging dock; current battery level: 100%
	 * The minimum battery level is set 10%.
	 */
	public Robot(){
		System.out.println("+++++-------------------------------------+++++");
		System.out.println("+++++         MyApp ----- MyRobot         +++++");    
		System.out.println("+++++         Paired successfully         +++++");
		System.out.println("+++++-------------------------------------+++++");
		position = new Point(chargingDock);
	}

	@Override
	public void run() {
		try {
			isWorking();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * After the AutoMode button is pressed
	 * Robot start to operate until the battery is higher than 10%.
	 * 
	 * Battery level decreases by 1% per second; thread
	 */

	public void isWorking() throws InterruptedException{
		while (inOperation()) { 
			for (int battery = getBattery(); battery > 0; battery--) {
				setBattery(battery);
				checkBattery();
				// when pause toggle ON
				while(!moveRobot()) { // busy wait
					int hold = getBattery();				
					setBattery(hold);
					if(moveRobot()) { // until pause toggle OFF
						printOnce = true;
						break;
					}
					if(printOnce) {
						System.out.println("");
						notifyObservers();
						printOnce = false;
					}
				}
				moving();	
				// when battery is flat
				if(battery == 0) {
					setOperation(false);
					break;
				}
				Thread.sleep(1000);   
			}
		}

	}

	/**
	 * Robot is moving according to the current battery level.
	 */
	public void moving() {
		int btry = getBattery();
		if (btry > 80) { robotPostion(10, 0);
		}else if(btry == 80) { detecteObs(); robotPostion(0, -10);
		}else if (btry < 80 && btry > 75) { robotPostion(0, -10);
		}else if (btry <=75 && btry > 68) { robotPostion(-10, 0);
		}else if (btry ==68) { detecteObs(); robotPostion(0, -10);
		}else if (btry < 68 && btry > 63) { robotPostion(0, -10);
		}else if (btry <=63 && btry > 51) { robotPostion(10, 0);
		}else if (btry <=51 && btry > 36) { robotPostion(0, -10);
		}else if (btry ==36) { detecteWall(); robotPostion(-10, 0);
		}else if (btry < 36 && btry > 31) { robotPostion(-10, 0);
		}else if (btry <=31 && btry > 21) { robotPostion(0, 10);
		}else if (btry <=21 && btry > 16) { robotPostion(-10, 0);
		}else if (btry <=16 && btry > 10) { robotPostion(0, -10);
		}else if (btry < minBatteryLevel && btry>3) { robotPostion(-25, 16);
		}else if (btry < 4) { robotPostion(0, 38);
		}
	}

	/**
	 *  check battery level then notify observer 
	 */
	public void checkBattery() {
		int btry = getBattery();
		// display battery level on console every 10 sec
		if(btry%10 == 0 && btry > 10) {
			setShowBattery(true);
			System.out.println();
			notifyObservers();
			setShowBattery(false);
		// display status on console every 2 sec
		}else if (btry % 2 == 0 && btry % 10 != 0 && btry > 10 ) {
			System.out.println();
			notifyObservers();
		//if it's below minimum battery level, stop operation	
		}else if (btry == minBatteryLevel) {
			setOperation(false);
			notifyObservers();
			System.out.println("+----------------------------+");
		}
	}

	/**
	 * When an obstacle detected, notify observer
	 */
	public void detecteObs() {
		setObstacleDetected(true);
		System.out.println("\n******************************");
		System.out.println("* Obstacle.detected()        *");
		notifyObservers();
		System.out.println("******************************");
		setObstacleDetected(false);
	}

	/**
	 * When a wall detected, notify observer
	 */
	public void detecteWall() {
		setWallDetected(true);
		System.out.println("\n******************************");
		System.out.println("* Wall.detected()            *");
		notifyObservers();
		System.out.println("******************************");
		setWallDetected(false);
	}

	/**
	 * update the robot location
	 */
	public void robotPostion(int x, int y) {
		position.x = position.x + x;
		position.y = position.y + y;
		position.setLocation(position.x, position.y);
	}

	public boolean pause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public int getBattery() {
		return batteryLevel;
	}
	
	public int minBattery() {
		return minBatteryLevel;
	}

	public void setBattery(int battery) {
		batteryLevel = battery;
	}

	public boolean inOperation() {
		return operation;
	} 
	
	public void setOperation(boolean op) {
		operation = op;
	} 

	public boolean wallDetected() {
		return wallDetected;
	} 

	public boolean obstacleDetected() {
		return obstacleDetected;
	} 

	public boolean showBattery() {
		return showBattery;
	} 

	public void setWallDetected(boolean detect) {
		wallDetected = detect;
	} 

	public void setObstacleDetected(boolean detect) {
		obstacleDetected = detect;
	} 

	public void setShowBattery(boolean show) {
		showBattery = show;
	} 

	public Point position() {
		return position;
	}

	public boolean moveRobot() {
		return moveRobot;
	} 

	public void setmoveRobot(boolean move) {
		moveRobot = move;
	}
}
