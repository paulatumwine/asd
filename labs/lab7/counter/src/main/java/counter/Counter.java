package counter;

public class Counter extends Subject {
	ICounterState counterState;
	private int count=0;
	
	public void increment(){
		counterState.increment();
		donotify(count);
	}
	
	public void decrement(){
        counterState.decrement();
		donotify(count);
	}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCounterState(ICounterState counterState) {
        this.counterState = counterState;
    }
}
