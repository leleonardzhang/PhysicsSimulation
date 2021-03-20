package components.mainpanel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JSlider;

import components.barchart.bar.BarPair;
import components.pendulum.animator.Lock;
import components.pendulum.imageprotractor.ImageProtractor;
import components.pendulum.imageprotractor.ImageProtractorInterface;
import components.pendulum.pendulum.ObserverPendulum;
import components.pendulum.pendulum.ObserverPendulumInterface;
import components.ruler.Ruler;
import components.ruler.RulerInterface;
import models.pendulum.PendulumModelFactory;
import models.pendulum.PendulumModelInterface;
import util.annotations.Column;
import util.annotations.EditablePropertyNames;
import util.annotations.Label;
import util.annotations.MaxValue;
import util.annotations.MinValue;
import util.annotations.PreferredWidgetClass;
import util.annotations.PropertyNames;
import util.annotations.Row;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"numberOfPendulum", "gravity", "friction", "pendulum", "ruler", "protractor", "gravity", "planet"})
@EditablePropertyNames({"gravity", "friction", "pendulum", "ruler", "protractor", "gravity", "planet"})
public class MainPanel implements MainPanelInterface{
	
	public static int gravity, 
			friction = PendulumModelFactory.DEFAULT_FRICTION;
	public static final int MARGIN_BTW_PAIR = 10, MARGIN = 5, BAR_WIDTH = 10, BARCHART_X = 1000, BARCHART_Y = 0;
	private Planet planet;
	private int numberOfPendulum = 0;
	private List<ObserverPendulumInterface> pendulum = new ArrayList<ObserverPendulumInterface> ();
	private RulerInterface ruler = new Ruler(20, 20, 675, 60);
	private ImageProtractorInterface protractor = new ImageProtractor(350, 20, 150, 300);
	private boolean enable = false;
	private Lock aLock = new Lock();
	

	public MainPanel() {
		increaseNumberOfPendulum();
		setPlanet(Planet.Earth);
	}

	@Override
	public void setGravity(int g) {
		gravity = g;
		planet = Planet.Other;
		setModel();
	}

	@Override
	public void setFriction(int f) {
		friction = f;
		setModel();
	}

	@Override
	@PreferredWidgetClass(JSlider.class)
	@MaxValue(25)
	@MinValue(1)
	@Row(1)
	@Column(0)
	public int getGravity() {
		return gravity;
	}

	@Override
	@PreferredWidgetClass(JSlider.class)
	@MaxValue(9)
	@MinValue(0)
	@Row(2)
	@Column(0)
	public int getFriction() {
		return friction;
	}


	@Override
	@Row(2)
	@Column(0)
	public List<ObserverPendulumInterface> getPendulum() {
		return pendulum;
	}


	@Override
	public RulerInterface getRuler() {
		return ruler;
	}

	@Override
	public void setRuler(RulerInterface newRuler) {
		ruler = newRuler;
	}


	@Override
	public int getNumberOfPendulum() {
		return numberOfPendulum;
	}

	
	@Override
	public ImageProtractorInterface getProtractor() {
		return protractor;
	}

	@Override
	public void setProtractor(ImageProtractorInterface newProtractor) {
		protractor = newProtractor;
	}

	@Override
	@Visible(false)
	public void setModel() {
		for (int i = 0; i < numberOfPendulum; i ++) {
			pendulum.get(i).setModel();
		}
	}

	@Override
	@PreferredWidgetClass(JButton.class)
	@Row(5)
	@Column(0)
	@Label("\u25B6")
	public void pause() {
		if (enable) {
			for (int i = 0; i < numberOfPendulum; i ++) {
				pendulum.get(i).stop();
			}
			enable = false;
		}
		else {
			for (int i = 0; i < numberOfPendulum; i ++) {
				pendulum.get(i).resume();
			}
			enable = true;
		}
	}

	@Override
	@PreferredWidgetClass(JButton.class)
	@Row(5)
	@Column(1)
	@Label("\u25A0")
	public void reset() {
		pause();
		for (int i = 0; i < numberOfPendulum; i ++) {
			pendulum.get(i).setAngle(0);
		}
	}

	@Override
	@PreferredWidgetClass(JButton.class)
	@Row(4)
	@Column(0)
	@Label("+")
	public void increaseNumberOfPendulum() {
		if (numberOfPendulum < PendulumModelFactory.MAX_CAPACITY) {
			PendulumModelInterface newModel = PendulumModelFactory.getDefaultModel();
			ObserverPendulumInterface newPendulum = new ObserverPendulum(newModel, enable, 
					new BarPair(BARCHART_X + pendulum.size() * (BAR_WIDTH + MARGIN + BAR_WIDTH + MARGIN_BTW_PAIR), BARCHART_Y), aLock);
			pendulum.add(newPendulum);
			numberOfPendulum ++;
		}
	}

	@Override
	@PreferredWidgetClass(JButton.class)
	@Row(4)
	@Column(1)
	@Label("-")
	public void decreaseNumberOfPendulum() {
		if (numberOfPendulum > 0) {
			numberOfPendulum --;
			pendulum.get(numberOfPendulum).getAnimator().interrupt();
			pendulum.get(numberOfPendulum).getModel().removePropertyChangeListener(pendulum.get(numberOfPendulum));
			pendulum.remove(numberOfPendulum);
		}
	}

	@Override
	@Row(0)
	@Column(0)
	public Planet getPlanet() {
		return planet;
	}

	@Override
	public void setPlanet(Planet newPlanet) {
		setGravity(newPlanet.getValue());
		planet = newPlanet;
	}


}
