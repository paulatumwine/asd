package application;

import framework.EmailSender;
import framework.EmailSenderImpl;

public class Application {

	public static void main(String[] args)  {
		BankService bankService = new BankServiceImpl();
		SecureEmailSender secureEmailSender = new SecureEmailSender();
		EmailSender emailSender = new EmailSenderImpl();
		secureEmailSender.setEmailSender(emailSender);
		
		bankService.setEmailSender(secureEmailSender);
		
		bankService.deposit(100.0);		
	}
}
