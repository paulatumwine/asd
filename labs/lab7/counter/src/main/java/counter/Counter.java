package counter;

public class Counter extends Subject {
    CountHandler countHandler;
	ICounterState counterState;
	private int count=0;
	
	public void increment(){
		counterState.increment();
		donotify(count);
		countHandler.handleCount(count);
	}
	
	public void decrement(){
        counterState.decrement();
		donotify(count);
        countHandler.handleCount(count);
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

    public void setCountHandler(CountHandler countHandler) {
        this.countHandler = countHandler;
    }
}
