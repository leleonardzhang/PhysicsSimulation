package components.mainpanel;

import java.util.List;

import components.pendulum.imageprotractor.ImageProtractorInterface;
import components.pendulum.pendulum.ObserverPendulumInterface;
import components.ruler.RulerInterface;

public interface MainPanelInterface {
	public enum Planet {Moon(2), Mars(4), Earth(10), Jupiter(25), Other(20); 
		private int value;
		public int getValue() {
			return value;
		}
		private Planet(int newValue) {
			value = newValue;
		}
	};
	void setGravity(int g);
	void setFriction(int f);
	int getGravity();
	int getFriction();
	void setModel();
	List<ObserverPendulumInterface> getPendulum();
	RulerInterface getRuler();
	void setRuler(RulerInterface newRuler);
	void pause();
	void reset();
	int getNumberOfPendulum();
	void increaseNumberOfPendulum();
	void decreaseNumberOfPendulum();
	ImageProtractorInterface getProtractor();
	void setProtractor(ImageProtractorInterface newProtractor);
	Planet getPlanet();
	void setPlanet(Planet newPlanet);
}
