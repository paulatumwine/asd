package counter;

public class SingleDigitState implements ICounterState {
    Counter counter;

    public SingleDigitState(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + 1);
        if (counter.getCount() > 10) {
            ICounterState state = new DoubleDigitState(counter);
            counter.setCounterState(state);
        }
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - 1);
    }
}
