package models.pendulum;

public class TimerModel implements TimerModelInterface{
	
	private long startTime, stopTime;
	
	public TimerModel() {
		startTime = System.currentTimeMillis();
	}
	
	public void reset() {
		startTime = System.currentTimeMillis();
	}
	
	public long getTimeElapsed() {
		return System.currentTimeMillis() - startTime;
	}
	
	public void pause() {
		stopTime = System.currentTimeMillis();
	}
	
	public void resume() {
		startTime = startTime + System.currentTimeMillis() - stopTime;
	}
}
