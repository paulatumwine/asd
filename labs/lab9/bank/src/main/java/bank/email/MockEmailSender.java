package bank.email;

public class MockEmailSender implements IEmailSender {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email in test");
    }
}
