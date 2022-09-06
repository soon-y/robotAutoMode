package automode;

/**
 * observer for battery level
 * @author Soonyoung Park
 *
 */
public class BatteryObserver implements Observer{ 

	@Override
	public void update(Subject sub) {
		
		/**
		 *  update
		 *  1. when back to home due to low battery status
		 *  2. print out the battery level when it's a multiple of ten.
		 */
		if(!((Robot)sub).inOperation() && ((Robot)sub).moveRobot()) {
			System.out.println("+----------------------------+");		
			System.out.println("| LOW BATTERY                |");
			System.out.println("| 10% battery remaining      |");
			System.out.println("| Robot.BackToChargingDock() |");
		}
		if(((Robot)sub).showBattery() == true) {
			System.out.println("**** Current Battery: " + ((Robot)sub).getBattery() + "% ****\n");
		}
			
	}

	@Override
	public String getString() {
		return "Robot.Battery_observing";
	}

}
