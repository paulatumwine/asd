import java.util.ArrayList;
import java.util.List;

public class UnregisteredHandler extends RecordHandler {

    List<String> unregisteredCars = new ArrayList<>();

    public UnregisteredHandler(RecordHandler nextHandler) {
        super(nextHandler);
    }

    public void setUnregisteredCars(List<String> unregisteredCars) {
        this.unregisteredCars = unregisteredCars;
    }

    @Override
    public void handle(Record record) {
        if(unregisteredCars.contains(record.getLicensePlate())) {
            System.out.println("Unregistered car: " + record.getLicensePlate()
                    + " seen by " + record.getCameraId()
                    + ", sending owner a ticket");
        } else {
            nextHandler.handle(record);
        }
    }
}
