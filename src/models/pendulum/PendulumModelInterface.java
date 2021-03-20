package models.pendulum;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;

public interface PendulumModelInterface extends PropertyListenerRegisterer{
	// Next state
	void nextPosition();
	// Pendulum
	int getX();
	void setX(int newX);
	int getY();
	void setY(int newY);
	int getHeight();
	void setHeight(int h);
	int getWidth();
	void setWidth(int w);
	
	// invariants
	double getAngle();
	double getFriction();
	double getGravity();
	double getLength();
	double getMass();
	double getMaxAngle();
	
	
	void removePropertyChangeListener(PropertyChangeListener aListener);
	
	void resetTimer();
	void stopTimer();
	void resumeTimer();
	boolean getEnable();
	
	long getTimeElapsed();
	void setTimeElapsed(long newTime);
}
