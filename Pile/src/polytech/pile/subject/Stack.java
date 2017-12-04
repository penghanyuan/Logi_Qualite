package polytech.pile.subject;

import java.util.ArrayList;
import java.util.List;

import polytech.pile.observers.Observer;
import polytech.pile.observers.ViewBase;
import polytech.pile.observers.ViewSummit;

/**
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
	public void addObservers(ViewSummit viewSummit, ViewBase viewBase) {
		this.observers.add(viewSummit);
		this.observers.add(viewBase);
	}

	/**
	 * Function f
	 */
	public void stackChanged() {
		this.notifyObserver();
	}

	public int pop() throws Exception {
		if (this.list.isEmpty()) {
			throw new Exception("stack is empty!");
		}
		int result = this.list.get(0);
		list.remove(0);
		if (this.list.size() < 5) {
			this.stackChanged();
		}
		this.stackChanged();

		return result;
	}

	public List<Integer> getList() {
		return this.list;
	}

	public void push(int value) {
		this.list.add(0, value);
		this.stackChanged();
	}

	public void clear() {
		this.list.clear();
		this.stackChanged();
	}

}
