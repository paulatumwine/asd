package counter;

public class LogHandler extends CountHandler {

    public LogHandler(CountHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCount(int count) {
        System.out.println("Writing count: " + count + " to log file");
    }
}
