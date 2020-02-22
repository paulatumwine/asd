package lab2.bank.src.main.java.bank.dao;

import lab2.bank.src.main.java.bank.domain.Account;

import java.util.Collection;

public interface IAccountDAO {
	void saveAccount(Account account);
	void updateAccount(Account account);
	Account loadAccount(long accountnumber);
	Collection<Account> getAccounts();
}
