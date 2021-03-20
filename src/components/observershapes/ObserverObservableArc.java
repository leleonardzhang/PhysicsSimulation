package components.observershapes;

import java.awt.Stroke;

public interface ObserverObservableArc extends ObserverObservableShapeInterface{
	Stroke getStroke();
	void setStroke(Stroke newStroke);
	int getStartAngle();
	void setStartAngle(int newStartAngle);
	int getEndAngle();
	void setEndAngle(int newEndAngle);
}
