package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

/**
 * AutoMode controller
 * detects time when the AutoMode button pressed,
 * operates Robot,
 * updates Status View
 * @author Soonyoung Park
 *
 */
public class AutoModeController extends MouseAdapter implements Runnable{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	private Application model;
	private View app;

	public AutoModeController(Application model, View app) {
		this.model = model;
		this.app = app;
		addMouseListener();
		Thread.currentThread().setPriority(5);
	}

	@Override
	public void run() {
		setText();
	}

	public void addMouseListener() {
		app.getButtons().addMouseListener(this);
	}

	public void colorSetting(JButton button, Color color, Color font) {
		button.setOpaque(true);
		button.setBackground(color);
		button.setForeground(font);
		button.setBorderPainted(false);	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/** 
		 * Precondition:
		 * AutoMode hasn't been operated yet.
		 * AutoMode button pressed.
		 */

		if(!model.myRobot().inOperation()) {
			Color pressed = new Color(19, 78, 168);
			colorSetting(app.getButtons().getAutoButton(), pressed, Color.WHITE);

			System.out.println("===============================================");
			System.out.println(" ('_')");
			System.out.println(" User : pressed AutoMode at "+ dtf.format(now));
			System.out.println("===============================================");	
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Color bg = new Color(189, 226, 255);
		colorSetting(app.getButtons().getAutoButton(), bg, Color.BLACK);			
	}

	public void setText() {
		int num = 100-model.myRobot().getBattery();
		double size = 0.0;
		int time = num;

		app.getStatusView().setStatus().setText("Auto Mode");
		app.getStatusView().showSize().setText(size+"");
		app.getStatusView().showTime().setText(time + " mins");
		//when AutoMode button is clicked
		if(model.myRobot().inOperation() == true) {
			int robotBattery = model.myRobot().getBattery();
			while (robotBattery > 0) {
				int battery = model.myRobot().getBattery();
				num = 100-battery;
				size = num/3.4;
				time = num/2;
				//when pause toggle ON/OFF
				if(!model.myRobot().moveRobot()) {
					app.getStatusView().setStatus().setText("Pause");
				}else {
					app.getStatusView().setStatus().setText("Auto Mode");
				}
				//when back to Home
				if(!model.myRobot().inOperation()) {
					app.getStatusView().setStatus().setText("Standby");
				}

				// keep updating time and dimension for cleaning every 1 sec
				app.getStatusView().showSize().setText(String.format("%.1f",size));;
				app.getStatusView().showTime().setText(time + " mins");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}

	}
}
