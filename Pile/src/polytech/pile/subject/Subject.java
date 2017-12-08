package polytech.pile.subject;

import java.util.List;
import polytech.pile.observers.Observer;

/**
 * Interface Subject
 * 
 * @author Peng Hanyuan & Wang Tianxue
 *
 */
public interface Subject {
	void notifyObserver();
	void addObservers(Observer view);
	void statusChanged();
}
