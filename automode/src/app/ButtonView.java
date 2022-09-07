package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 4 Buttons at the bottom of the interface
 * @author Soonyoung Park
 *
 */

public class ButtonView extends JPanel{
	private JButton autoMode = new JButton("");
	private JButton regionMode = new JButton("");
	private JButton roomMode = new JButton("");
	private JButton home = new JButton("");
	
	public ButtonView(int width, int height){
		setBackground(Color.white);
		setLayout(null);
		setSize(width, height/9);
		fontSetting();
		setBounds(width/4, height/9);
		setText();
		addButtons();		
		setVisible(true);
	}
	
	public void fontSetting() {
		autoMode.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		regionMode.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		roomMode.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		home.setFont(new Font("Helvetica",  Font.PLAIN, 14));	
	}
	
	public void setBounds(int width, int height) {
		autoMode.setBounds(0, 0, width, height);
		regionMode.setBounds(width + 1, 0, width, height);
		roomMode.setBounds(width*2 +2, 0, width, height);
		home.setBounds(width*3+3, 0, width, height);
		
		colorSetting(autoMode);
		colorSetting(regionMode);
		colorSetting(roomMode);
		colorSetting(home);	
	}
	
	public void colorSetting(JButton button) {
		Color bg = new Color(189, 226, 255);
		button.setOpaque(true);
		button.setBackground(bg);
		button.setBorderPainted(false);
	}
	
	public void addButtons() {
		add(autoMode);
		add(regionMode);
		add(roomMode);
		add(home);
	}
	
	public void addActionListener(ActionListener listener) {
		autoMode.addActionListener(listener);
	}
	
	public void addMouseListener(MouseListener listener) {
		autoMode.addMouseListener(listener);
	}
	
	public void setText() {
		autoMode.setText("<HTML><body><center>AUTO<br>MODE</center></body></HTML>");
		regionMode.setText("<HTML><body><center>REGION<br>MODE</center></body></HTML>");
		roomMode.setText("<HTML><body><center>ROOM<br>MODE</center></body></HTML>");
		home.setText("<HTML><body><center>HOME</center></body></HTML>");
	}
	
	public JButton getAutoButton() {
		return autoMode;
	}

}
