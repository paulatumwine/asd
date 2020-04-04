package bank.service;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.proxies.LoggingProxy;

import java.lang.reflect.Proxy;
import java.util.Collection;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
    private ClassLoader classLoader;
    private IAccountDAO loggingProxy;
	
	public AccountService(){
		accountDAO=new AccountDAO();
		classLoader = IAccountDAO.class.getClassLoader();
		loggingProxy = (IAccountDAO) Proxy.newProxyInstance(classLoader,
                new Class[]{ IAccountDAO.class }, new LoggingProxy(accountDAO));
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
        loggingProxy.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = loggingProxy.loadAccount(accountNumber);
		account.deposit(amount);
        loggingProxy.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = loggingProxy.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return loggingProxy.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = loggingProxy.loadAccount(accountNumber);
		account.withdraw(amount);
        loggingProxy.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
