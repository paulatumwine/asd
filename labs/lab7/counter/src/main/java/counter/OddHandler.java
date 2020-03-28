package counter;

public class OddHandler extends CountHandler {

    public OddHandler(CountHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCount(int count) {
        if (count==1 || count%3 == 0)
            if (count<15 || count==17 || count==19)
                System.out.println("Blue");
            else
                System.out.println("Orange");

        nextHandler.handleCount(count);
    }
}
