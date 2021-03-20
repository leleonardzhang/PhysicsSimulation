package components.timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import components.listenersupport.PropertyListenerSupport;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;


@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"time"})
@EditablePropertyNames({})
public class TimerView implements TimerViewInterface{
	
	private double time = 0;
	private PropertyListenerSupport propertyListenerSupport = new PropertyListenerSupport();
	
	@Override
	public void setTime(double newTime) {
		double oldTime = time;
		time = newTime;
		if (time < 0.01) {
			time = 0.00;
		}
		propertyListenerSupport.notifyAllListeners(
				new PropertyChangeEvent(this, "time", oldTime, time));
	}

	@Override
	public double getTime() {
		return time;
	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyListenerSupport.addElement(aListener);    
    }
}
