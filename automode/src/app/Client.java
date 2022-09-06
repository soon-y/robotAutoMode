package app;

import automode.Robot;

/** 
 * HAW-IE-Software Engineering
 * @author Soonyoung Park
 * @date 02.06.2022
 */

public class Client {

	public static void main(String[] args) throws Exception {

		Robot robot= new Robot();
		Application model = Application.getInstance(robot);
		Controller control = new Controller(); 
	}

}
