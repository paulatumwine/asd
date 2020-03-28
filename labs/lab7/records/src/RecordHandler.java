public abstract class RecordHandler {

    RecordHandler nextHandler;

    public RecordHandler(RecordHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(Record record);
}
