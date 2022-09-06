package automode;

/**
 * observer interface
 * @author Soonyoung Park
 *
 */
public interface Observer {
	public abstract void update(Subject sub);
	public abstract String getString();
}
