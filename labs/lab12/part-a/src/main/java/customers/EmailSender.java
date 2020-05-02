package customers;

public class EmailSender implements IEmailSender {
    String outgoingMailServer = "smtp.acme.com";
    private ILogger logger = new Logger();

    public void sendEmail(String message) {
        logger.log(message);
    }
}
