package application;

import framework.Service;

@Service
public class EmailServiceImpl implements EmailService{

	public void send(String content) {
		System.out.println("sending email: "+content);
		
	}

}
