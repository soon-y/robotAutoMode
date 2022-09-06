package automode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class is subject of observer
 * @author Soonyoung Park
 *
 */

public abstract class Subject{

	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * attach Observer to subject
	 * @param observer
	 */
	public void add(Observer observer){
		observers.add(observer);
		System.out.println(observer.getString());
	}
	
	/**
	 * delete Observer from subject
	 * @param observer
	 */
	public void delete(Observer observer) {
		observers.remove(observer);
    }

	/**
	 * notify changes to Observer
	 */
	public void notifyObservers(){
		Iterator it = observers.iterator();
		while (it.hasNext()) {
			Observer observer = (Observer)it.next();
			observer.update(this);
		}
	}

}
