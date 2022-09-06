package app;

import java.awt.Color;

/**
 * Obstacle is drawn on the map.
 * @author Soonyoung Park
 *
 */

public class Obstacle implements Decorator{
	private int width;
	private int height;
	private int x;
	private int y;
	
	public Obstacle(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		Color obs = new Color(166, 166, 166);
		Drawing.pen().setColor(obs);
		Drawing.pen().fillRect(x, y, width, height);	
	}
	
}
