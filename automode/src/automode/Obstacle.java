package automode;

/**
 * concrete decorator
 * @author Soonyoung Park
 *
 */

public class Obstacle extends Decorator{

	public Obstacle(Map map) {
        super(map);
    }
	
    public void update() {
    	System.out.print(addObs());
    }
       
    private String addObs() {
        return " + Obstacle   *\n";
    }
	
}
