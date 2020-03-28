public class SpeedingHandler extends RecordHandler {

    private static final int SPEED_LIMIT = 60;

    public SpeedingHandler(RecordHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Record record) {
        if (record.getSpeed() > SPEED_LIMIT) {
            System.out.println("Car: " + record.getLicensePlate() + " seen driving at " + record.getSpeed() +" by " + record.getCameraId());
        } else {
            nextHandler.handle(record);
        }
    }
}
