package bank.email;

public class EmailSender implements IEmailSender {

    static EmailSender emailSender;

    private EmailSender() {
        if (emailSender != null) throw new RuntimeException("");
    }

    public static synchronized EmailSender getInstance() {
        if (emailSender == null) emailSender = new EmailSender();
        return emailSender;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email in production");
    }
}
