package application;

import framework.EmailSender;

public interface BankService {
	void deposit(double amount);
	void setEmailSender(EmailSender emailService);
}
