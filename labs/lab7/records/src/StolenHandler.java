import java.util.ArrayList;
import java.util.List;

public class StolenHandler extends RecordHandler {

    List<String> stolenPlates = new ArrayList<>();

    public StolenHandler(RecordHandler nextHandler) {
        super(nextHandler);
    }

    public void setStolenPlates(List<String> stolenPlates) {
        this.stolenPlates = stolenPlates;
    }

    @Override
    public void handle(Record record) {
        if(stolenPlates.contains(record.getLicensePlate())) {
            System.out.println("Stolen car: " + record.getLicensePlate() + " seen by " + record.getCameraId());
        } else {
            nextHandler.handle(record);
        }
    }
}
