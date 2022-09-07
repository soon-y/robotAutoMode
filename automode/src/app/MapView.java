package app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Map contains Robot, Path, Obstacle, Segment
 * @author Soonyoung Park
 *
 */
public class MapView extends JPanel{
	ArrayList<Decorator> deco = new ArrayList<>();
	private int robotSize;
	private int robotEdge;
	private int width;		
	private int height;
	private int xMargin;	
	private int yMargin;
	private int mapWidth; 	
	private int mapHeight;
	private int x; 			
	private int y;
	private int wallWidth; 	
	private int wallHeight;
	private int obsWidth; 	
	private int obsHeight;
	private int x0;			
	private int y0;
	private int obsX;		
	private int obsY;
	private int wallX;		
	private int wallY;

	public MapView(int width, int height, Application model) {
		this.width = width;
		this.height = height/9*6;
		xMargin = this.width/10;
		yMargin = this.height/20;
		mapWidth = this.width - 2*xMargin;
		mapHeight = this.height-2*yMargin;
		robotSize = mapWidth/8;
		robotEdge = robotSize/3;
		x= model.myRobot().position().x; 
		y= model.myRobot().position().y;
		x0 = x;
		y0 = y;
		
		setBackground(Color.white);
		setLayout(null);
		setSize(width, height/9*6);	
		setVisible(true);
	}
	
	public int obsX() {return obsX;}
	
	public int obsY() {return obsY;}
	
	public int wallX() {return wallX;}
	
	public int wallY() {return wallY;}
	
	public void setObsX(int x) {obsX = x;}
	
	public void setObsY(int y) {obsY = y;}
	
	public void setWallX(int x) {wallX = x;}
	
	public void setWallY(int y) {wallY = y;}
	
	public int x() {return x;}

	public int y() {return y;}

	public void newX(int newX) {x = newX;}

	public void newY(int newY) {y = newY;}
	
	public int  xMargin() {return xMargin;}

	public int  yMargin() {return yMargin;}

	public int  mapWidth() {return mapWidth;}

	public int  mapHeight() {return mapHeight;}

	public int robotSize() {return robotSize;}
	
	public int robotEdge() {return robotEdge;}
	
	public int wallWidth() {return wallWidth;}
	
	public int wallHeight() {return wallHeight;}
	
	public int obsWidth() 	{return obsWidth;}
	
	public int obsHeight() 	{return obsHeight;}

	public void wallWidth(int width) 	{wallWidth = width;}
	
	public void wallHeight(int height) 	{wallHeight = height;}
	
	public void obsWidth(int width) 	{obsWidth = width;}
	
	public void obsHeight(int height) 	{obsHeight = height;}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Drawing.set(g);	
		
		Color scannedRoom = new Color(243, 243, 243 );
		g.setColor(scannedRoom);
		g.fillRect(xMargin, yMargin, mapWidth, mapHeight);

		Segment newSeg = new Segment(wallX(), wallY(), wallWidth(), wallHeight());
		deco.add(newSeg);		

		Obstacle newObs = new Obstacle(obsX(), obsY(), obsWidth(), obsHeight());
		deco.add(newObs);	
		
		// draw paths
		Graphics2D path = (Graphics2D) g;
		path.setStroke(new BasicStroke(10));	
		Path newPath = new Path(x0+robotEdge*2, y0+robotEdge*2, x()+robotEdge*2, y()+robotEdge*2);
		x0 = x(); y0 = y();
		deco.add(newPath);
		
		for(Decorator object: deco) {
			object.draw();
		}
		
		RobotIcon robotIcon = new RobotIcon(x(),y(), robotSize, robotEdge);
		robotIcon.draw();		
	}

}
