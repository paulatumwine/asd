package application;

import framework.Inject;
import framework.Profile;
import framework.Service;

@Service
@Profile(value="Two")
public class SecureEmailServiceImpl implements EmailService{
	@Inject(value="message")
	String theMessage;

	public void send(String content) {
		System.out.println("sending secure email: "+content+" , message="+theMessage);
		
	}

}
