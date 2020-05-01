package application;

import framework.Inject;
import framework.Service;

@Service
public class BankServiceImpl implements BankService{
	@Inject
	private EmailService emailService;
	
	@Inject(value="bankname")
	String bankName;
	
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}


	public void deposit() {
		emailService.send("deposit to "+bankName);		
	}
	
}
