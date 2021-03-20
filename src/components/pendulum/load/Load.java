package components.pendulum.load;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import components.listenersupport.PropertyListenerSupport;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@PropertyNames({"x", "y", "width", "height", "filled", "color"})
@EditablePropertyNames({"x", "y"})
public class Load implements LoadInterface {
	
	private PropertyListenerSupport propertyListenerSupport = new PropertyListenerSupport();
	private int x = 190, y = 110, width = 20, height = 20;
	private boolean filled = true;
	private Color color = Color.RED;
	
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
		height = newWidth;
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "width", oldWidth, width));
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "height", oldWidth, height));
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		width = newHeight;
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "width", oldHeight, width));
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "height", oldHeight, height));
	}

	@Override
	public boolean getFilled() {
		return filled;
	}

	@Override
	public Color getColor() {
		return color;
	}


	@Override
	public void setFilled(boolean isFilled) {
		filled = isFilled;
	}


	@Override
	public void setColor(Color newColor) {
		color = newColor;
	}

}
