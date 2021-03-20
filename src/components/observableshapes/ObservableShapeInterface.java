package components.observableshapes;

import java.beans.PropertyChangeListener;

import components.shapes.ShapeInterface;

public interface ObservableShapeInterface extends ShapeInterface{
	void addPropertyChangeListener(PropertyChangeListener aListener);
}
