package components.timer;

import java.beans.PropertyChangeListener;

public interface TimerViewInterface {
	void addPropertyChangeListener(PropertyChangeListener aListener);
	void setTime(double newTime);
	double getTime();
}
