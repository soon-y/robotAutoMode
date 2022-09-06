package automode;

/**
 * Decorator for decorator pattern
 * @author Soonyoung Park
 *
 */
public abstract class Decorator implements Map {
	protected Map map;

	protected Decorator(Map map) { 
        this.map = map;
    }
	
}
