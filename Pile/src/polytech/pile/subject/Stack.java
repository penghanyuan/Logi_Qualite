package polytech.pile.subject;

import java.util.ArrayList;
import java.util.List;

import polytech.pile.observers.Observer;
import polytech.pile.observers.ViewBase;
import polytech.pile.observers.ViewSummit;

public class Stack implements Subject {
	private List<Integer> list;

	private List<Observer> observers;

	public Stack() {
		this.list = new ArrayList<Integer>();
		this.observers = new ArrayList<Observer>();
	}

	/**
	 * notify observers
	 * 
	 * @param
	 */
	@Override
	public void notifyObserver(List<Observer> observers) {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public void addObservers(ViewSummit viewSummit, ViewBase viewBase) {
		this.observers.add(viewSummit);
		this.observers.add(viewBase);
	}

	public void removeObserver(int index) {

	}

	/**
	 * 
	 */
	public void stackSummitChanged() {
		this.notifyObserver(this.observers.subList(0, 1));
	}

	/**
	 * 
	 */
	public void stackBaseChanged() {
		this.notifyObserver(this.observers.subList(1, 2));
	}

	public int pop() throws Exception {
		if (this.list.isEmpty()) {
			throw new Exception("stack is empty!");
		}
		int result = this.list.get(0);
		if (this.list.size() < 5) {
			this.stackBaseChanged();
		}
		list.remove(0);
		this.stackSummitChanged();

		return result;
	}

	/**
	 * 
	 * @return summit
	 */
	public int getSummit() {
		return this.list.get(0);
	}

	public void push(int value) {
		this.list.add(0, value);
		if (this.list.size() <= 5) {
			this.stackBaseChanged();
		}
		this.stackSummitChanged();
	}

	public List<Integer> getLastFive() {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = this.list.size() - 5 < 0 ? 0 : this.list.size() - 5; i < this.list.size(); i++) {
			result.add(this.list.get(i));
		}
		return result;
	}

}
