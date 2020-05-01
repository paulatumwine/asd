package application;

import framework.EmailSender;
import framework.EmailSenderImpl;


public class Application {

	public static void main(String[] args)  {
		BankService bankService = new BankServiceImpl();
		EmailSender emailService = new EmailSenderImpl();
		bankService.setEmailSender(emailService);
		
		bankService.deposit(100.0);		
	}
}
