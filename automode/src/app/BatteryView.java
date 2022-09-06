package app;

import java.awt.*;

import javax.swing.*;

/**
 * Battery View
 * @author Soonyoung Park
 *
 */
public class BatteryView extends JPanel {
	private int height;
	private int width;
	private float length;
	private float hue;
	private float saturation;
	private float brightness;
	private JLabel MyRobotIs = new JLabel("My Robot IE 004");
	private JLabel BatteryIs = new JLabel("100 %");
	
	private Icon pauseIcon = new ImageIcon("images/circle-pause-solid.png", "pause");
	private Icon playIcon = new ImageIcon("images/circle-play-solid.png", "play");
	private JToggleButton toggle = new JToggleButton(pauseIcon);
	
	public BatteryView(int width, int height) {
		this.width = width;
		this.height = height/9;
		length = width-(width/4);
		hue = .6f;
		saturation = .89f;
		brightness = .63f;
		
		Color bg = new Color(189, 226, 255);
		setBackground(bg);
		setLayout(null);
		setSize(width, height/9);
		fontSetting();
		setBounds();
		addComp();		
		setVisible(true);	
	}
	
	public void addComp() {
		add(MyRobotIs);
		add(BatteryIs);
		add(toggle);
	}
	
	public void setBounds() {
		MyRobotIs.setBounds(10, 10, width, height/3*2);
		BatteryIs.setBounds(0, height/3*2, width/7, height/3);	
		BatteryIs.setHorizontalAlignment(JLabel.RIGHT);
		toggle.setBounds(width-(height/2)-20, height/5*1, height/5*2, height/5*2);
		toggle.setVisible(false);
	}
	
	public void fontSetting() {
		MyRobotIs.setFont(new Font("Helvetica", Font.BOLD, 30));
		BatteryIs.setFont(new Font("Helvetica", Font.PLAIN, 14));
	}
	
	// bar graph for the battery level
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color batteryC = Color.getHSBColor(hue, getS(), getB());
		g.setColor(batteryC);
		g.fillRect(width/7+10, height/3*2+(height/3/4), (int)getBtrLength(), height/5); 
	}
	
	public float getS() {
		return saturation;
	}
	
	public float getB() {
		return brightness;
	}
	
	public void setS(float s) {
		saturation = s;
	}
	
	public void setB(float b) {
		brightness = b;
	}

	public float getBtrLength() {
		return length;
	}
		
	public void setBtrLength(float length) {
		this.length = length;
	}
	
	public JLabel batteryLabel() {
		return BatteryIs;
	}
	
	public JToggleButton toggle() {
		return toggle;
	}
	
	public Icon playIcon() {
		return playIcon;
	}
	
	public Icon pauseIcon() {
		return pauseIcon;
	}

}
