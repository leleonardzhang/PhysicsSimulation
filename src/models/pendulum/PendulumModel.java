package models.pendulum;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import components.listenersupport.PropertyListenerSupport;

public class PendulumModel extends PropertyListenerSupport implements PendulumModelInterface {
	
	private static final int MILLISECOND_PER_SECOND = 1000;
	private static final double LENGTH_SCALE = 0.1;
	private static final int GRAM_PER_KILOGRAM = 1000;
	private static final double FRICTION_SCALE = 1; 
	
	private PropertyListenerSupport aPropertyListenerSupport = new PropertyListenerSupport();
	private double length, mass, gravity, friction, angle;
	private int x, y, height, width;
	private long timer, stoptimer, timeElapsed;
	private double maxAngle;
	private double h;
	private boolean enable = false;
	
	public PendulumModel() {};

	public PendulumModel(int newX, int newY, double l, double m, double g, double f, double a) {
		timer = System.currentTimeMillis();
		setX(newX);
		setY(newY);
		length = l;
		mass = m;
		gravity = g;
		friction = Math.sqrt(f / 10 * gravity / length * mass * mass * 4) ;
		System.out.println(friction);
		angle = a * Math.PI/180;
		h = Math.sqrt(gravity / length - friction * friction / 4 / mass / mass);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		aPropertyListenerSupport.addElement(aListener);
	}
	
	@Override
	public void nextPosition() {
		if (enable) {
			setTimeElapsed(System.currentTimeMillis() - timer);
		}
		else {
			setTimeElapsed(stoptimer - timer);
		}
		
		
		
		double timeInSecond = timeElapsed/MILLISECOND_PER_SECOND;
		// double angleAtT = angle * Math.cos((Math.sqrt(gravity/(length * LENGTH_SCALE)) * timeInSecond));
		
		maxAngle = angle * Math.exp(friction / 2 / mass * (-1) * timeInSecond);
		
	
		
		double angleAtT = maxAngle * (Math.cos(h * timeInSecond) + friction / 2 / mass / h * Math.sin(h * timeInSecond));
		
		setHeight((int) Math.round(Math.cos(angleAtT) * length));
		setWidth((int) Math.round(Math.sin(angleAtT) * length));
		
		
	}
	
	@Override
	public void resetTimer() {
		timer = System.currentTimeMillis();
	}

	@Override
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		aPropertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "x", oldX, x));
	}

	@Override
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		aPropertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "y", oldY, y));
	}

	@Override
	public void setHeight(int h) {
		int oldHeight = height;
		height = h;
		aPropertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "height", oldHeight, height));
	}

	@Override
	public void setWidth(int w) {
		int oldWidth = width;
		width = w;
		aPropertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "width", oldWidth, width));
	}
	

	@Override
	public void removePropertyChangeListener(PropertyChangeListener aListener) {
		aPropertyListenerSupport.removeElement(aListener);
	}

	@Override
	public void stopTimer() {
		stoptimer = System.currentTimeMillis();
		enable = false;
	}

	@Override
	public void resumeTimer() {
		timer = System.currentTimeMillis() - stoptimer + timer;
		enable = true;
	}

	@Override
	public boolean getEnable() {
		return enable;
	}
	
	@Override
	public double getLength() {
		return length;
	}

	@Override
	public double getMaxAngle() {
		return maxAngle;
	}

	@Override
	public long getTimeElapsed() {
		return timeElapsed;
	}

	@Override
	public void setTimeElapsed(long newTime) {
		long oldTimeElapsed = timeElapsed;
		timeElapsed = newTime;
		aPropertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "timeElapsed", oldTimeElapsed, timeElapsed));
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public double getAngle() {
		return angle;
	}

	@Override
	public double getFriction() {
		return friction;
	}

	@Override
	public double getGravity() {
		return gravity;
	}

	@Override
	public double getMass() {
		return mass;
	}


}
