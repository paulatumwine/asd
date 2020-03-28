package counter;

public class DatabaseHandler extends CountHandler {

    public DatabaseHandler(CountHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCount(int count) {
        System.out.println("Saving count: " + count + " to DB");

        nextHandler.handleCount(count);
    }
}
