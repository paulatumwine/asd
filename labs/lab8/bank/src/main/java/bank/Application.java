package bank;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.proxies.TimingProxy;
import bank.service.AccountService;
import bank.service.IAccountService;

import java.lang.reflect.Proxy;
import java.util.Collection;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		IAccountService timingProxy = (IAccountService) Proxy.newProxyInstance(
		        IAccountService.class.getClassLoader(),
                new Class[] { IAccountService.class },
                new TimingProxy(accountService)
        );

		// create 2 accounts;
        timingProxy.createAccount(1263862, "Frank Brown");
        timingProxy.createAccount(4253892, "John Doe");
		//use account 1;
        timingProxy.deposit(1263862, 240);
        timingProxy.deposit(1263862, 529);
        timingProxy.withdraw(1263862, 230);
		//use account 2;
        timingProxy.deposit(4253892, 12450);
        timingProxy.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<Account> accountlist = timingProxy.getAllAccounts();
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


