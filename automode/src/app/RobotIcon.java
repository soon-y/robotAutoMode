package app;

import java.awt.Color;

/**
 * Robot is drawn on the map.
 * @author Soonyoung Park
 *
 */
public class RobotIcon implements Decorator{
	private int edge;
	private int robot;
	private int x;
	private int y;
	
	public RobotIcon(int x, int y, int robot, int edge) {
		this.robot = robot;
		this.edge = edge;
		this.x = x;
		this.y = y;
	}	
	
	public void draw() {
		Color rEdge = new Color(255, 187, 74);
		Drawing.pen().setColor(rEdge);
		Drawing.pen().fillOval(x-edge/2, y-edge/2, robot+edge, robot+edge);

		Color rIcon = new Color(249, 139, 31);
		Drawing.pen().setColor(rIcon);
		Drawing.pen().fillOval(x, y, robot, robot);	
		
	}
	
}

