package app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Segment is drawn on the map.
 * @author Soonyoung Park
 *
 */
public class Segment implements Decorator{
	private int width;
	private int height;
	private int x;
	private int y;
	
	public Segment(int x, int y, int width, int height) {
		this.width = width;
		this.height =height;
		this.x = x;
		this.y = y;
	}	
	
	public void draw() {
		Color wall = new Color(209, 209, 209);
		Drawing.pen().setColor(wall);
		Drawing.pen().fillRect(x, y, width, height);		
	}
	
}
