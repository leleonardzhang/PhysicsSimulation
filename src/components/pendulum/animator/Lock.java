package components.pendulum.animator;

public class Lock {
	
	private boolean lock = false;
	
	public synchronized void getLock() {
		while (lock) {
			// System.out.println(Thread.currentThread().toString() + "begins waiting");
			try {
				wait();
				// System.out.println(Thread.currentThread().toString() + "ends waiting");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		lock = true;
		// System.out.println(Thread.currentThread().toString() + "gets the lock");
	}
	
	public synchronized void releaseLock() {
		// System.out.println(Thread.currentThread().toString() + "notifies");
		notify();
		lock = false;
		// System.out.println(Thread.currentThread().toString() + "releases the lock");
	}
	
}
