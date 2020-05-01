package application;

import framework.Inject;
import framework.Profile;
import framework.Service;

@Service
@Profile(value="One")
public class EmailServiceImpl implements EmailService{
	@Inject(value="message")
	String theMessage;

	public void send(String content) {
		System.out.println("sending email: "+content+" , message="+theMessage);
		
	}

}
