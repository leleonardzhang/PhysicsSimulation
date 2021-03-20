package components.pendulum.pendulum;

import java.beans.PropertyChangeEvent;

import javax.swing.JSlider;

import components.barchart.bar.BarPair;
import components.barchart.bar.BarPairInterface;
import components.mainpanel.MainPanel;
import components.pendulum.animator.Lock;
import components.pendulum.animator.PendulumAnimatorCommand;
import components.pendulum.load.Load;
import components.pendulum.load.LoadInterface;
import components.pendulum.string.PendulumString;
import components.pendulum.string.PendulumStringInterface;
import components.timer.TimerView;
import components.timer.TimerViewInterface;
import models.pendulum.PendulumModel;
import models.pendulum.PendulumModelFactory;
import models.pendulum.PendulumModelInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.MaxValue;
import util.annotations.MinValue;
import util.annotations.PreferredWidgetClass;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"load", "string", "length", "mass", "angle", "barPair", "timer"})
@EditablePropertyNames({"string", "load", "length", "mass", "angle"})
public class ObserverPendulum implements ObserverPendulumInterface{
	
	private int length = PendulumModelFactory.DEFAULT_LENGTH, 
			mass = PendulumModelFactory.DEFAULT_MASS, 
			angle = PendulumModelFactory.DEFAULT_ANGLE;
	private LoadInterface load = new Load();
	private PendulumStringInterface string;
	private PendulumModelInterface model;
	private PendulumAnimatorCommand animator;
	private boolean enable;
	private BarPairInterface barPair;
	private Lock aLock;
	private boolean isHeightUpdate = false, isWidthUpdate = false;
	private int updatedWidth, updatedHeight;
	private TimerViewInterface timer = new TimerView();
	
	
	public ObserverPendulum(PendulumModelInterface newModel, boolean isEnable, BarPairInterface newBarPair, Lock newLock) {
		enable = isEnable;
		model = newModel;
		string = new PendulumString(model);
		model.addPropertyChangeListener(this);
		aLock = newLock;
		animator = new PendulumAnimatorCommand(model, aLock);
		barPair = newBarPair;
		if (!enable) {
			stop();
		}
		animator.start();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == model) {
			if ("height".equals(evt.getPropertyName())) {
				
				updatedHeight = (int) evt.getNewValue();
				
				isHeightUpdate = true;
			}
			else if ("width".equals(evt.getPropertyName())) {
				updatedWidth = (int) evt.getNewValue();
				
				isWidthUpdate = true;
			}
			else if ("timeElapsed".equals(evt.getPropertyName())) {
				timer.setTime((double) (((long) evt.getNewValue()) / 1000.0));
			}
			
			if (isHeightUpdate & isWidthUpdate) {
				isHeightUpdate = false;
				isWidthUpdate = false;
				
				string.setHeight(updatedHeight);
				load.setY(string.getY() + updatedHeight - load.getHeight()/2);
				load.setX(string.getX() + updatedWidth - load.getWidth()/2);
				string.setWidth(updatedWidth);
				barPair.getBars().get(0).setHeight((int) (model.getLength()) - updatedHeight);
				barPair.getBars().get(1).setHeight((int) updatedHeight - (int) (model.getLength() * Math.cos(model.getMaxAngle())));
				
				
				//System.out.println(Thread.currentThread().toString() + "tries to release the lock");
				//aLock.releaseLock();
			}
			
		}
		
	}

	@Override
	public PendulumStringInterface getString() {
		return string;
	}

	@Override
	public LoadInterface getLoad() {
		return load;
	}

	@Override
	public void setString(PendulumStringInterface newString) {
		string = newString;
	}

	@Override
	public void setLoad(LoadInterface newLoad) {
		load = newLoad;
	}
	
	@Override
	public void setLength(int l) {
		length = l;
		setModel();
	}

	@Override
	public void setMass(int m) {
		mass = m;
		setModel();
	}
	
	@Override
	public void setAngle(int a) {
		angle = a;
		setModel();
	}

	@Override
	@PreferredWidgetClass(JSlider.class)
	@MaxValue(500)
	@MinValue(10)
	public int getLength() {
		return length;
	}

	@Override
	@PreferredWidgetClass(JSlider.class)
	@MaxValue(50)
	@MinValue(1)
	public int getMass() {
		return mass;
	}
	
	@Override
	public int getAngle() {
		return angle;
	}

	@Override
	@Visible(false)
	public void setModel() {
		PendulumModelInterface oldModel = model;
		model = new PendulumModel(
				PendulumModelFactory.DEFAULT_STRING_X, 
				PendulumModelFactory.DEFAULT_STRING_Y, 
				length, 
				mass, 
				MainPanel.gravity, 
				MainPanel.friction, 
				angle);
		
		model.addPropertyChangeListener(this);
		if (!enable) {
			stop();
		}
		animator.setNewModel(model);
		oldModel.removePropertyChangeListener(this);
	}

	@Override
	public PendulumModelInterface getModel() {
		return model;
	}

	@Override
	public PendulumAnimatorCommand getAnimator() {
		return animator;
	}

	@Override
	public void stop() {
		model.stopTimer();
		enable = false;
	}

	@Override
	public void resume() {
		model.resumeTimer();
		enable = true;
	}

	@Override
	public BarPairInterface getBarPair() {
		return barPair;
	}

	@Override
	public void setBarPair(BarPairInterface newBarPair) {
		barPair = newBarPair;
	}

	@Override
	public TimerViewInterface getTimer() {
		return timer;
	}


	
}
