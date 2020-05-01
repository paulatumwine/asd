package application;

import framework.Inject;
import framework.Service;

@Service
public class EmailServiceImpl implements EmailService{
	@Inject(value="message")
	String theMessage;

	public void send(String content) {
		System.out.println("sending email: "+content+" , message="+theMessage);
		
	}

}
