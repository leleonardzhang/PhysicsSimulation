package components.pendulum.pendulum;

import java.beans.PropertyChangeListener;

import components.barchart.bar.BarPairInterface;
import components.pendulum.animator.PendulumAnimatorCommand;
import components.pendulum.load.LoadInterface;
import components.pendulum.string.PendulumStringInterface;
import components.timer.TimerViewInterface;
import models.pendulum.PendulumModelInterface;

public interface ObserverPendulumInterface extends PropertyChangeListener{
	PendulumStringInterface getString();
	LoadInterface getLoad();
	void setString(PendulumStringInterface newString) ;
	void setLoad(LoadInterface newLoad);
	int getLength();
	void setLength(int l);
	int getMass();
	void setMass(int m);
	int getAngle();
	void setAngle(int a);
	void setModel();
	PendulumModelInterface getModel();
	PendulumAnimatorCommand getAnimator();
	void stop();
	void resume();
	BarPairInterface getBarPair();
	void setBarPair(BarPairInterface newBarPair);
	TimerViewInterface getTimer();
}
