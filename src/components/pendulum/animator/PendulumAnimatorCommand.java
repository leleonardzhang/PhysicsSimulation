package components.pendulum.animator;

import models.pendulum.PendulumModelInterface;

public class PendulumAnimatorCommand extends Thread{
	private boolean enable;
	private PendulumModelInterface model;
	private Lock aLock;
	
	public PendulumAnimatorCommand(PendulumModelInterface newModel, Lock newLock){
		super();
		enable = true;
		model = newModel;
		aLock = newLock;
	}
	
	public void pause() {
		enable = false;
	}
	
	public void unpause() {
		enable = true;
	}
	
	public void setNewModel(PendulumModelInterface newModel) {
		model = newModel;
	}
	
	
	public void run() {
		while (enable) {
			//System.out.println(Thread.currentThread().toString() + "tries to get lock");
			//aLock.getLock();
			model.nextPosition();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e){
				
			}
		}
	}
}
