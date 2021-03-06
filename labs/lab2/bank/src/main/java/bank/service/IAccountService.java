package lab2.bank.src.main.java.bank.service;

import lab2.bank.src.main.java.bank.domain.Account;

import java.util.Collection;

public interface IAccountService {
    Account createAccount(Account account, String customerName);
    Account getAccount(long accountNumber);
    Collection<Account> getAllAccounts();
    void deposit(long accountNumber, double amount);
    void withdraw(long accountNumber, double amount);
    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
    void addInterest();
}
