package bank.service;

import bank.adapters.AccountAdapter;
import bank.adapters.IAccountAdapter;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.dto.AccountDTO;
import bank.proxies.LoggingProxy;
import bank.proxies.TimingProxy;

import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.stream.Collectors;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
    private ClassLoader classLoader;
    private IAccountDAO loggingProxy;
    private IAccountDAO timingProxy;
    private IAccountAdapter accountAdapter;

	public AccountService(){
		accountDAO=new AccountDAO();
		classLoader = IAccountDAO.class.getClassLoader();
		loggingProxy = (IAccountDAO) Proxy.newProxyInstance(
		        classLoader,
                new Class[]{ IAccountDAO.class },
                new LoggingProxy(accountDAO)
        );
		timingProxy = (IAccountDAO) Proxy.newProxyInstance(
		        classLoader,
                new Class[] { IAccountDAO.class },
                new TimingProxy(loggingProxy)
        );
		accountAdapter = new AccountAdapter();
	}

	public AccountDTO createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
        timingProxy.saveAccount(account);
		return accountAdapter.getAccountDTO(account);
	}

	public void deposit(long accountNumber, double amount) {
		Account account = timingProxy.loadAccount(accountNumber);
		account.deposit(amount);
        timingProxy.updateAccount(account);
	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = timingProxy.loadAccount(accountNumber);
		return accountAdapter.getAccountDTO(account);
	}

	public Collection<AccountDTO> getAllAccounts() {
	    Collection<Account> accounts = timingProxy.getAccounts();
		return accounts.stream().map(a -> accountAdapter.getAccountDTO(a)).collect(Collectors.toList());
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = timingProxy.loadAccount(accountNumber);
		account.withdraw(amount);
        timingProxy.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
