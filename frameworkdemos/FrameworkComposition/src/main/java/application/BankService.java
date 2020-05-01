package application;

public interface BankService {
	void deposit(double amount);
	void setEmailSender(SecureEmailSender secureEmailSender);
}
