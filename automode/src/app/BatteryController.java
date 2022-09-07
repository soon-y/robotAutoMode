package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Battery controller updates Battery status, 
 * changes color depending on Battery level 
 * @author Soonyoung Park
 *
 */
public class BatteryController extends Thread implements ActionListener{
	private Application model;
	private View app;
	private float btrLevel;
	private boolean pause = false;
	private boolean toggled = false;
	Timer timer;


	public BatteryController(Application model, View app) {
		this.model = model;
		this.app = app;
		btrLevel = app.getBattryView().getBtrLength();
		timer = new Timer(1000, this);
		timer.start();
	}

	public void run() {
		try {
			batteryUpdate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * update battery label
	 * @throws InterruptedException 
	 */
	public void batteryUpdate() throws InterruptedException {
		int battery = model.myRobot().getBattery();
		while(battery > 0) {
			// update the label for battery level
			if(model.myRobot().inOperation()) {
				app.getBattryView().batteryLabel().setText(model.myRobot().getBattery()+" %");		
			}
			// when pause toggle ON
			if(pause()) {
				app.getBattryView().toggle().setIcon(app.getBattryView().playIcon());
				setPause(true);
				setToggled(true);
				model.myRobot().setmoveRobot(false);
			// when pause toggle OFF after toggling at least once
			}else if(!pause() && toggled()){
				app.getBattryView().toggle().setIcon(app.getBattryView().pauseIcon());
				setPause(false);
				model.myRobot().setmoveRobot(true);
			}
			// when battery level reaches minimum, back to standby mode
			if(battery < 11) {
				app.getBattryView().batteryLabel().setText(10+" %");
				app.getBattryView().toggle().setVisible(false);	
			}
		}

	}

	/**
	 * Once automode starts,
	 * change graphics, brightness and saturation according to Battery level
	 * when pause toggle is clicked, 
	 * - toggle on  = pause,  display playIcon
	 * - toggle off = resume, display pauseIcon
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		BatteryView btr = app.getBattryView();
		float s = btr.getS(); 
		float b = btr.getB();
		if(model.myRobot().inOperation() && model.myRobot().moveRobot()) {
			float length = (btrLevel/100) * model.myRobot().getBattery();
			if(model.myRobot().getBattery()<100) {
				if(s-.01>0) s -= 0.005;
				if(b-.01>0) b -= 0.001;
			}
			btr.setBtrLength((int)length);
			btr.setS(s);
			btr.setB(b);
			app.getBattryView().repaint();
		}

		if(app.getBattryView().toggle().isSelected()) {
			app.getBattryView().toggle().setIcon(app.getBattryView().playIcon());
			model.myRobot().setmoveRobot(false);
		}else {
			app.getBattryView().toggle().setIcon(app.getBattryView().pauseIcon());
			model.myRobot().setmoveRobot(true);
		}
	}

	public boolean pause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean toggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
}
