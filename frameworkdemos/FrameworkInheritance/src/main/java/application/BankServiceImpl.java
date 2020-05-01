package application;

import framework.EmailSender;

public class BankServiceImpl implements BankService {
	private EmailSender emailSender;

	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void deposit(double amount) {
		emailSender.send("customer@gmail.com", "deposit of $" + amount);

	}

}
