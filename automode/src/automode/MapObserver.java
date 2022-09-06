package automode;

/**
 * Observer for map
 * @author Soonyoung Park
 *
 */
public class MapObserver implements Observer{
	private Map map;

	@Override
	public void update(Subject sub) {
		/**
		 * when obstacle detected, instantiate map with decorator pattern
		 */
		if(((Robot)sub).obstacleDetected()) {
			map = new Obstacle(new ScannedMap());
			map.update();
		}
		
		/**
		 * when wall detected, instantiate map with decorator pattern
		 */
		if(((Robot)sub).wallDetected() == true) {
			map = new Segment(new ScannedMap());
			map.update();
		}
		
		/**
		 *  update
		 *  1. while operating
		 *  2. when paused
		 */
		if(((Robot)sub).inOperation() == true) {
			if(((Robot)sub).moveRobot() && !((Robot)sub).obstacleDetected() && !((Robot)sub).wallDetected()){
				System.out.println("Robot.moving/scanning() ");
			}
			if(!((Robot)sub).moveRobot()) {
				System.out.println("-----------------------------------------------");
				System.out.println("Robot.pause()");
			}
		}
	}

	@Override
	public String getString() {
		return "Robot.Map_generating";
	}

}
