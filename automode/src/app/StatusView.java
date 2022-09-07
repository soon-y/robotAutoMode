package app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Status View: 6 JLable indicating status, dimension, time
 * @author Soonyoung Park
 *
 */
public class StatusView extends JPanel{
	private JLabel status = new JLabel("Status");
	private JLabel size = new JLabel("<HTML><body>Dimension(m<sup style=\"font-size:12;\">2</sup>)</body></HTML>");
	private JLabel time = new JLabel("Time");
	private JLabel setStatus = new JLabel("");
	private JLabel showSize = new JLabel("");
	private JLabel showTime = new JLabel("");
	private int width;
	private int height;
	
	public StatusView(int width, int height){
		this.width = width/3;
		this.height = height/9/2;
		
		Color bg = new Color(189, 226, 255); //skyblue
		setBackground(bg);
		setLayout(null);
		setSize(width, height/9);
		fontSetting();
		setBounds();
		setText();
		addComp();		
		setVisible(true);
	}

	public void setText() {
		setStatus.setText("Standby");
		showSize.setText("20");
		showTime.setText("45 mins");
	}
	
	public void setBounds() {
		status.setBounds(0, 0, width, height);
		size.setBounds(width, 0, width, height);
		time.setBounds(width*2, 0, width, height);
		setStatus.setBounds(0, height, width, height);
		showSize.setBounds(width, height, width, height);
		showTime.setBounds(width*2, height, width, height);

		status.setVerticalAlignment(JLabel.BOTTOM);
		size.setVerticalAlignment(JLabel.BOTTOM);
		time.setVerticalAlignment(JLabel.BOTTOM);
		setStatus.setVerticalAlignment(JLabel.CENTER);
		showSize.setVerticalAlignment(JLabel.CENTER);
		showTime.setVerticalAlignment(JLabel.CENTER);
		
		status.setHorizontalAlignment(JLabel.CENTER);
		size.setHorizontalAlignment(JLabel.CENTER);
		time.setHorizontalAlignment(JLabel.CENTER);
		setStatus.setHorizontalAlignment(JLabel.CENTER);
		showSize.setHorizontalAlignment(JLabel.CENTER);
		showTime.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void addComp() {
		add(status);
		add(size);
		add(time);
		add(setStatus);
		add(showSize);
		add(showTime);
	}
	
	public void fontSetting() {
		
		status.setFont(new Font("Helvetica", Font.PLAIN, 16));
		size.setFont(new Font("Helvetica", Font.PLAIN, 16));
		time.setFont(new Font("Helvetica", Font.PLAIN, 16));
		setStatus.setFont(new Font("Helvetica", Font.BOLD, 20));
		showSize.setFont(new Font("Helvetica", Font.BOLD, 20));
		showTime.setFont(new Font("Helvetica", Font.BOLD, 20));

	}
	
	public JLabel setStatus() {
		return setStatus;
	}
	
	public JLabel showSize() {
		return showSize;
	}
	
	public JLabel showTime() {
		return showTime;
	}

}
