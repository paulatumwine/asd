import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        UnpaidTicketHandler unpaidTicketHandler = new UnpaidTicketHandler(null);
        UnregisteredHandler unregisteredHandler = new UnregisteredHandler(unpaidTicketHandler);
        SpeedingHandler speedingHandler = new SpeedingHandler(unregisteredHandler);
        StolenHandler stolenHandler = new StolenHandler(speedingHandler);

        RecordReceiver recordReceiver = new RecordReceiver(stolenHandler);
        recordReceiver.receiveRecord(new Record("VA189L", 70, 1101));

        List<String> unregisteredCars = new ArrayList<>();
        unregisteredCars.add("VA189L");
        unregisteredHandler.setUnregisteredCars(unregisteredCars);
        recordReceiver.receiveRecord(new Record("VA189L", 40, 1101));
    }
}
