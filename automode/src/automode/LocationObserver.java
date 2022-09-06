package automode;

/**
 * Observer for location, update location of robot
 * @author Soonyoung Park
 *
 */
public class LocationObserver implements Observer{

	@Override
	public void update(Subject sub) {
		/**
		 *  update
		 *  1. when obstacle/wall detected
		 *  2. while operating
		 *  3. when paused
		 *  4. when back to home
		 */
		if(((Robot)sub).obstacleDetected() || ((Robot)sub).wallDetected()) {
			System.out.println("* Robot.Location ("+((Robot)sub).position().x +","
					+((Robot)sub).position().y+")   *");
			System.out.println("* Robot.updateLocation()     *");			
		}

		if(((Robot)sub).inOperation()) {
			if(!((Robot)sub).obstacleDetected() && !((Robot)sub).wallDetected()){
				System.out.println("Robot.currentLocation("+((Robot)sub).position().x +", "
						+((Robot)sub).position().y+")");
				System.out.println("Robot.updateLocation() ");
			}	
			if(!((Robot)sub).moveRobot()) {
				System.out.println("-----------------------------------------------");
			}
		}else {
			System.out.println("| Robot.LocationSaved()      |");
		}		
	}

	@Override
	public String getString() {
		return "===============================================";
	}

}
