package counter;

public class DecrementCommand implements ICommand {

    Counter counter;

    public DecrementCommand(Counter counter) {
        this.counter = counter;
    }

    public void execute() {
        counter.decrement();
    }

    public void unExecute() {
        counter.increment();
    }
}
