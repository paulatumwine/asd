public class RecordReceiver {

    RecordHandler recordHandler;

    RecordReceiver(RecordHandler recordHandler) {
        this.recordHandler = recordHandler;
    }

    public void receiveRecord(Record record) {
        handle(record);
    }

    public void handle(Record record) {
        recordHandler.handle(record);
    }
}
