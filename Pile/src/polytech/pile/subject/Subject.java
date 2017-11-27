package polytech.pile.subject;

import java.util.List;

import polytech.pile.observers.Observer;

public interface Subject {
	void notifyObserver(List<Observer> observers);
}