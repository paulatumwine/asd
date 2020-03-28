package counter;

public class EvenHandler extends CountHandler {

    public EvenHandler(CountHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCount(int count) {
        if (count==0 || count%2 == 0)
            if (count<10 || count==12 || count==13)
                System.out.println("Red");
            else
                System.out.println("Green");

        nextHandler.handleCount(count);
    }
}
