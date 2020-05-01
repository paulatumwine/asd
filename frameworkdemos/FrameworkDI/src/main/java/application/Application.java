package application;

import framework.FWContext;

public class Application {

	public static void main(String[] args) {
		FWContext fWContext = new FWContext();
		
		BankService bankService =  (BankService) fWContext.getBeanOftype(BankService.class);
		if (bankService != null) bankService.deposit();

	}

}
