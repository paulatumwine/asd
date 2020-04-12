package bank.dao;

import bank.domain.Account;

import java.util.Collection;

public class AccountDAOLogger extends AbstractAccountDAO {

    public AccountDAOLogger(IAccountDAO accountDAO) {
        super(accountDAO);
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Saving account " + account);
        accountDAO.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("Updating account " + account);
        accountDAO.saveAccount(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {
        System.out.println("Getting account " + accountnumber);
        return accountDAO.loadAccount(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        System.out.println("Getting all accounts");
        return accountDAO.getAccounts();
    }
}
