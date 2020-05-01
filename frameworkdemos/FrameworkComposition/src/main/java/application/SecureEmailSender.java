package application;

import framework.EmailSender;

public class SecureEmailSender {
	EmailSecurityChecker emailSecurityChecker = new EmailSecurityChecker();
	EmailSender emailSender;
		
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendSecureEmail(String emailAddress, String message) {
		if (emailSecurityChecker.isEmailSecure(emailAddress, message)) {
			emailSender.send(emailAddress, message);
		}
	}
}


