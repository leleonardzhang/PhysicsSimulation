package components.observershapes;

import java.awt.Color;

public interface ObserverObservableOvalInterface extends ObserverObservableShapeInterface{
	boolean getFilled();
	void setFilled(boolean isFilled);
	Color getColor();
	void setColor(Color newColor);
}
