package application;


public class Application {

	public static void main(String[] args)  {
		BankService bankService = new BankServiceImpl();
		SecureEmailSender secureEmailSender = new SecureEmailSender();
		bankService.setEmailSender(secureEmailSender);
		
		bankService.deposit(100.0);		
	}
}
