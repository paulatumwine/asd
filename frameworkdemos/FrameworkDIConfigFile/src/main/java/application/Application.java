package application;

import framework.FWApplication;
import framework.Inject;

public class Application implements Runnable{
	@Inject
	BankService bankService;

	public static void main(String[] args) {
		FWApplication.run(Application.class);
	}

	@Override
	public void run() {
		bankService.deposit();		
	}
}
