package bank;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;

import java.util.Collection;



public class Application {
	public static void main(String[] args) {
	    HistoryList historyList = new HistoryList();
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
        Command command = new DepositCommand(accountService, 1263862, 240);
        command.execute();
		historyList.addCommand(command);
        command = new DepositCommand(accountService, 1263862, 529);
        command.execute();
        historyList.addCommand(command);
        command = new WithdrawCommand(accountService, 1263862, 230);
        command.execute();
        historyList.addCommand(command);

		//use account 2;
        command = new DepositCommand(accountService, 4253892, 12450);
        command.execute();
        historyList.addCommand(command);
        command = new TransferFundsCommand(accountService, 4253892, 1263862, 100, "payment of invoice 10232");
        command.execute();
        historyList.addCommand(command);

//        historyList.undo();

		// show balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


