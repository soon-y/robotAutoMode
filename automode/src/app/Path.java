package app;

import java.awt.Color;

/**
 * Path is drawn along Robot position.
 * @author Soonyoung Park
 *
 */
public class Path implements Decorator{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Path(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw() {
		Color line = new Color(217, 211, 200 );
		Drawing.pen().setColor(line);
		Drawing.pen().drawLine(x1, y1, x2, y2);	
	}
}
