package components.pendulum.string;

import java.awt.BasicStroke;
import java.awt.Stroke;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import components.listenersupport.PropertyListenerSupport;
import models.pendulum.PendulumModelFactory;
import models.pendulum.PendulumModelInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;


@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"x", "y", "width", "height", "stroke"})
@EditablePropertyNames({"x", "y", "width", "height"})
public class PendulumString implements PendulumStringInterface {
	
	public static final String X_STRING = "x";
	public static final String Y_STRING = "y";
	public static final String WIDTH_STRING = "width";
	public static final String HEIGHT_STRING = "height";
	
	private PropertyListenerSupport propertyListenerSupport = new PropertyListenerSupport();
	private int x = PendulumModelFactory.DEFAULT_STRING_X, y = PendulumModelFactory.DEFAULT_STRING_Y, 
			width = PendulumModelFactory.DEFAULT_WIDTH, height = PendulumModelFactory.DEFAULT_HEIGHT;
	private Stroke stroke = new BasicStroke(2.5f);
	private PendulumModelInterface model;
	
	
	public PendulumString(PendulumModelInterface newModel) {
		model = newModel;
	}
	
	@Override
    public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyListenerSupport.addElement(aListener);    
    }

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		model.setX(x);
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "x", oldX, x));
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		model.setY(y);
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "y", oldY, y));
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "width", oldWidth, width));
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "height", oldHeight, height));
	}


	@Override
	public Stroke getStroke() {
		return stroke;
	}

	@Override
	public void setStroke(Stroke newStroke) {
		stroke = newStroke;
	}
	
}
