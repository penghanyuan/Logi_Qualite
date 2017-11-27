package polytech.pile.subject;

import java.util.ArrayList;
import java.util.List;

import polytech.pile.observers.View;
import polytech.pile.observers.ViewBase;
import polytech.pile.observers.ViewSummit;

public class Stack {
	private List<Integer> list;

	private List<View> observers;

	public Stack() {
		this.list = new ArrayList<Integer>();
	}

	public void addObservers(ViewSummit viewSummit, ViewBase viewBase) {
		this.observers.add(viewSummit);
		this.observers.add(viewBase);
	}

	public void removeObserver(int index) {

	}

	/**
	 * notify observers
	 * 
	 * @param type
	 *            0=>summitObserver, 1=>baseObserver
	 */
	public void notifyObserver(int type) {
		this.observers.get(type).update();
	}

	/**
	 * 
	 */
	public void stackSummitChanged() {
		this.notifyObserver(0);
	}

	/**
	 * 
	 */
	public void stackBaseChanged() {
		this.notifyObserver(1);
	}

	public int pop() throws Exception {
		if (this.list.isEmpty()) {
			throw new Exception("stack is empty!");
		}
		int result = this.list.get(0);
		if (this.list.size() <= 5) {
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
		if (this.list.size() < 5) {
			this.stackBaseChanged();
		}
		this.list.add(0, value);
		this.stackSummitChanged();
	}

	public List<Integer> getLastFive() {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = this.list.size() - 5; i < this.list.size() && i >= 0; i++) {
			result.add(i);
		}
		return result;
	}
}
