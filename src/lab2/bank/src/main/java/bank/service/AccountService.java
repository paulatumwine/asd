package lab2.bank.src.main.java.bank.service;

import lab2.bank.src.main.java.bank.dao.AccountDAO;
import lab2.bank.src.main.java.bank.dao.IAccountDAO;
import lab2.bank.src.main.java.bank.domain.Account;
import lab2.bank.src.main.java.bank.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;

	
	public AccountService(){
		accountDAO=new AccountDAO();
	}

	public Account createAccount(Account account, String customerName) {
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	public void addInterest() {
		Iterator<Account> iterator = getAllAccounts().iterator();
		List<Account> updates = new ArrayList<>();
		while (iterator.hasNext()) {
			Account account = iterator.next();
			double interest = account.calculateInterest();
			account.deposit(interest);
			updates.add(account);
		}
		updates.forEach(a -> accountDAO.updateAccount(a));
	}
}
