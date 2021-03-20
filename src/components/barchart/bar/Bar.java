package components.barchart.bar;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import components.listenersupport.PropertyListenerSupport;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.RECTANGLE_PATTERN)
@PropertyNames({"x", "y", "width", "height", "color", "filled"})
@EditablePropertyNames({"x", "y", "width", "height", "color", "filled"})
public class Bar implements BarInterface{
	
	private int x, y, height, width;
	private Color color;
	private PropertyListenerSupport propertyListenerSupport = new PropertyListenerSupport();
	private boolean filled = true;
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyListenerSupport.addElement(aListener);    
    }
	
	@Override
	@Visible(false)
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
	@Visible(false)
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
	public boolean getFilled() {
		return filled;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setFilled(boolean isFilled) {
		boolean oldFilled = filled;
		filled = isFilled;
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "filled", oldFilled, filled));
	}

	@Override
	public void setColor(Color newColor) {
		Color oldColor = color;
		color = newColor;
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "color", oldColor, color));
	}
	
	
}
