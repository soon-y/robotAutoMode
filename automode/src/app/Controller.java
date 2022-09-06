package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main controller
 * 
 * @author Soonyoung Park
 *
 */
public class Controller implements ActionListener{
	
	private AutoModeController autoCon;
	private BatteryController batteryCon;
	private MapController mapCon;
	private View app;
	private Application model;	
	private Thread autoController;
	private Thread robotThread;
	
	/**
	 * instantiate each controller
	 * @param model Robot data
	 * @param app User Interface 
	 */
	
	public Controller(){
		model = Application.getInstance();		
		app = new View("My App", model);
		autoCon = new AutoModeController(model, app);
		batteryCon = new BatteryController(model, app);
		mapCon = new MapController(model, app);
		autoController = new Thread(autoCon);
		robotThread = new Thread(model.myRobot());
		addActionListener();
	}
	
	public void addActionListener() {
		app.getButtons().addActionListener(this);
	}
	
	/**
	 * Once AutoMode button is pressed
	 * run each thread
	 */
	@Override
	public void actionPerformed(ActionEvent e) throws IllegalThreadStateException{
		//when AutoMode button is pressed	
		if(e.getSource() == app.getButtons().getAutoButton()) {		
			if(!model.myRobot().inOperation()) {
			app.getBattryView().toggle().setVisible(true);
			start();
			}
		}
	}
	
	public void start() {
		model.start();
		batteryCon.start();
		autoController.start();
		robotThread.start();
	}

}
