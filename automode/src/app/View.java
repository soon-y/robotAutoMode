package app;
import javax.swing.*;

/**
 * User Interface contains 4 Jpanel
 * 1) Battery
 * 2) Status
 * 3) Map
 * 4) Buttons
 * @author Soonyoung Park
 *
 */
public class View extends JFrame{
	//iphone 11 pro: 1125 * 2436
	private static int frameWidth = 1125/3;	 //= 375;
	private static int frameHeight = 2436/3; //= 817
	private Application model;
	private BatteryView battery = new BatteryView(frameWidth, frameHeight);
	private ButtonView buttons = new ButtonView(frameWidth, frameHeight);;
	private MapView map;
	private StatusView status = new StatusView(frameWidth, frameHeight);

	public View(String title, Application model){
		this.model = model;
		map  = new MapView(frameWidth, frameHeight, model);
		setTitle(title);
		setSize(frameWidth,frameHeight+26); // 375 812
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setPosition();
		addComp();		
	    setVisible(true);
	}
	
	public void setPosition() {
		battery.setLocation	(0, 0);
		status.setLocation	(0, frameHeight/9);
		map.setLocation		(0, frameHeight/9*2);
		buttons.setLocation	(0, frameHeight/9*8);
	}
	
	public void addComp() {
		add(battery);
		add(status);
		add(map);
		add(buttons);
	}
	
	public StatusView getStatusView() {
		return status;
	}
	
	public BatteryView getBattryView() {
		return battery;
	}
	
	public ButtonView getButtons() {
		return buttons;
	}
	
	public MapView getMapView() {
		return map;
	}


}
