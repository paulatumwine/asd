import java.util.ArrayList;
import java.util.List;

public class UnpaidTicketHandler extends RecordHandler {

    List<String> unpaidTickets = new ArrayList<>();

    public UnpaidTicketHandler(RecordHandler nextHandler) {
        super(nextHandler);
    }

    public void setUnpaidTickets(List<String> unpaidTickets) {
        this.unpaidTickets = unpaidTickets;
    }

    @Override
    public void handle(Record record) {
        if(unpaidTickets.contains(record.getLicensePlate())) {
            System.out.println("Car with unpaid tickets: " + record.getLicensePlate()
                    + " seen by " + record.getCameraId()
                    + ", notifying the police");
        } else {
            nextHandler.handle(record);
        }
    }
}
