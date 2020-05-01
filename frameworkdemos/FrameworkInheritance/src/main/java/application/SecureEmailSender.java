package application;

import framework.EmailSenderImpl;

public class SecureEmailSender extends EmailSenderImpl{
	EmailSecurityChecker emailSecurityChecker = new EmailSecurityChecker();
	
	public void sendSecureEmail(String emailAddress, String message) {
		if (emailSecurityChecker.isEmailSecure(emailAddress, message)) {
			send(emailAddress, message);
		}
	}
}
