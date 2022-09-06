package automode;

/**
 * concrete decorator
 * @author Soonyoung Park
 *
 */

public class Segment extends Decorator{

	public Segment(Map map) {
        super(map);
    }
	
    public void update() {
    	System.out.print(addSeg());
    }
    
    private String addSeg() {
        return " + Segment    *\n";
    }

}
