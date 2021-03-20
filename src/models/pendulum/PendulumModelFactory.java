package models.pendulum;

public class PendulumModelFactory {
	public static final int DEFAULT_STRING_X = 500, DEFAULT_STRING_Y = 20, DEFAULT_WIDTH = 0, DEFAULT_HEIGHT = 100,
			DEFAULT_LENGTH = 300, DEFAULT_MASS = 10, DEFAULT_FRICTION = 0, DEFAULT_GRAVITY = 1, DEFAULT_ANGLE = 0, MAX_CAPACITY = 3;
	
	public synchronized static PendulumModelInterface getDefaultModel() {
		return new PendulumModel(DEFAULT_STRING_X, DEFAULT_STRING_Y, DEFAULT_LENGTH, DEFAULT_GRAVITY, DEFAULT_MASS, DEFAULT_FRICTION, DEFAULT_ANGLE);
	}
}
