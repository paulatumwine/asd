package framework;


public class EmailSenderImpl implements EmailSender{

	public void send(String emailAddress, String message) {
		System.out.println("sending email to "+emailAddress+ " , message="+message);
		
	}

}
