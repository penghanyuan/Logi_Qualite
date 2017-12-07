package polytech.pile.subject;

import java.util.List;

import polytech.pile.observers.Observer;

public interface Subject {
	void notifyObserver();
	void addObservers(Observer view);
	void statusChanged();
}
