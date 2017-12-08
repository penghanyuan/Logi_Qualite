package polytech.pile.subject;

import java.util.ArrayList;
import java.util.List;

import polytech.pile.observers.Observer;
import polytech.pile.observers.ViewSummit;

/**
 * Classe Stack
 * 
 * @author Peng Hanyuan & Wang Tianxue
 *
 */
public class Stack implements Subject {
	private List<Integer> list; // the list of integers
	private List<Observer> observers; // the list of observers

	/**
	 * Constructor
	 */
	public Stack() {
		this.list = new ArrayList<Integer>();
		this.observers = new ArrayList<Observer>();
	}

	/**
	 * Function for notifying observers
	 * 
	 * @param
	 */
	@Override
	public void notifyObserver() {
		for (Observer observer : this.observers) {
			observer.update();
		}
	}

	/**
	 * Function for adding observer viewSummit and viewBase
	 * 
	 * @param viewSummit
	 * @param viewBase
	 */
	@Override
	public void addObservers(Observer view) {
		this.observers.add(view);
	}

	/**
	 * Function for notifying the oberser when the status are changed
	 */
	@Override
	public void statusChanged() {
		this.notifyObserver();
	}

	/**
	 * Function for popping an element from the stack
	 * 
	 * @return the popped element
	 */
	public int pop() throws Exception {
		if (this.list.isEmpty()) {
			throw new Exception("stack is empty!");
		}
		int result = this.list.get(0);
		list.remove(0);
		this.statusChanged();

		return result;
	}

	/**
	 * Function for getting all the elements of the stack
	 *
	 * @return the list of all the elements of stack
	 */
	public List<Integer> getList() {
		return this.list;
	}

	/**
	 * Function for pushing un element into the stack
	 *
	 * @param value the pushed element 
	 */
	public void push(int value) {
		this.list.add(0, value);
		this.statusChanged();
	}

	/**
	 * Function for clearing all the elements of the stack
	 *
	 */
	public void clear() {
		this.list.clear();
		this.statusChanged();
	}

}
