package counter;

public abstract class CountHandler {

    CountHandler nextHandler;

    public CountHandler(CountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleCount(int count);
}
