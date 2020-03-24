package counter;

public class DoubleDigitState implements ICounterState {
    Counter counter;

    public DoubleDigitState(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + 2);
        if (counter.getCount() > 100) {
            ICounterState state = new TripleDigitState(counter);
            counter.setCounterState(state);
        }
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - 2);
        if (counter.getCount() < 10) {
            ICounterState state = new SingleDigitState(counter);
            counter.setCounterState(state);
        }
    }
}
