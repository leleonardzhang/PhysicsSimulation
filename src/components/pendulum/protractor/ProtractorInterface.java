package components.pendulum.protractor;

import java.util.List;

import components.observershapes.ObserverObservableArc;
import components.observershapes.ObserverObservableLine;

public interface ProtractorInterface {
	List<ObserverObservableLine> getLine();
	int getX();
	int getY();
	void setX(int newX);
	void setY(int newY);
	ObserverObservableArc getFirstArc();
	ObserverObservableArc getSecondArc();
}
