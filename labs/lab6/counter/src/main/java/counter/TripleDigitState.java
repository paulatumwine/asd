package counter;

public class TripleDigitState implements ICounterState {
    Counter counter;

    public TripleDigitState(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount() + 3);
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount() - 3);
        if (counter.getCount() < 100) {
            ICounterState state = new DoubleDigitState(counter);
            counter.setCounterState(state);
        }
    }
}
