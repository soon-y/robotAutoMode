package automode;

/**
 * concrete component
 * @author Soonyoung Park
 *
 */

public class ScannedMap implements Map{
	
	public ScannedMap() {
		update();
	}
	
	@Override
	public void update() {
		System.out.print("* Map.generated");
	}

}
