package application;

public class BankServiceImpl implements BankService {
	private SecureEmailSender emailSender;

	public void setEmailSender(SecureEmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void deposit(double amount) {
		emailSender.sendSecureEmail("customer@gmail.com", "deposit of $" + amount);

	}

}
