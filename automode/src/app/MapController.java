package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Map controller obtains the data from Robot
 * and update robot location, obstacle, segment on MapView
 * @author Soonyoung Park
 *
 */
public class MapController extends Thread implements ActionListener{
	private Application model;
	private View app;
	Timer timer;

	public MapController(Application model, View app) {
		this.model = model;
		this.app = app;
		timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MapView map = app.getMapView();
		
		int robotX = (int)model.myRobot().position().getX();
		int robotY = (int)model.myRobot().position().getY();
		int robot = map.robotSize() + map.robotEdge();
		
		if(robotX > map.xMargin() && robotX < map.mapWidth()) {
			if(robotY > map.yMargin() && robotY < map.mapHeight()) {
				map.newX(robotX); map.newY(robotY);
				map.repaint();
			}
		}
		
		if(model.myRobot().getBattery() == 80) {
			map.obsWidth(43); map.obsHeight(53);
			map.setObsX(robotX+robot); map.setObsY(robotY);
		}else if(model.myRobot().getBattery() == 68) {
			map.obsWidth(60); map.obsHeight(50);
			map.setObsX(robotX-60-map.robotEdge()); map.setObsY(robotY);
		}else {
			map.obsWidth(0); map.obsHeight(0);
			map.setObsX(0); map.setObsY(0);
		}
		
		if(model.myRobot().getBattery() == 36) {
			map.wallWidth(196); map.wallHeight(20);
			map.setWallX(robotX-194+robot); map.setWallY(robotY-20-map.robotEdge());
		}else {
			map.wallWidth(0); map.wallHeight(0);
			map.setWallX(0); map.setWallY(0);
		}			
	}

}
