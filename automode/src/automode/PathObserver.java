package automode;

/**
 * Observer for Path
 * @author Soonyoung Park
 * 
 * 
 */
public class PathObserver implements Observer{

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
			System.out.println("* Robot.UpdatePath()         *");
		}

		if(((Robot)sub).inOperation()) {
			if(((Robot)sub).moveRobot() && !((Robot)sub).obstacleDetected() && !((Robot)sub).wallDetected()){
				System.out.println("Robot.pathPlanning() ");
			}
			if(!((Robot)sub).moveRobot()) {
				System.out.println("Robot.savePathPlan()");
			}		
		}else {
			System.out.println("| Robot.PathSaved()          |");
		}
	}

	@Override
	public String getString() {
		return "Robot.Path_generating";
	}

}
