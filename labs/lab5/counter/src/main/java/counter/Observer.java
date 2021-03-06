package counter;

public abstract class Observer {
	private Counter counter;

	public Observer(Counter counter) {
		this.counter = counter;
	}
	
	public abstract void update();
}
