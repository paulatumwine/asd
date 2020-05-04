package customers;

public class EmailSender implements IEmailSender {
    String outgoingMailServer = "smtp.acme.com";
    private ILogger logger;

    public EmailSender(ILogger logger) {
        this.logger = logger;
    }

    public void sendEmail(String message) {
        logger.log(message);
    }
}
