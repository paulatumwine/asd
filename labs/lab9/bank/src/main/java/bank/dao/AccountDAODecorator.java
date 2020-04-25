package bank.dao;

import bank.domain.Account;

import java.util.Collection;

public abstract class AccountDAODecorator implements IAccountDAO {
    IAccountDAO decoratedDAO;

    public AccountDAODecorator(IAccountDAO accountDAO) {
        this.decoratedDAO = accountDAO;
    }

    @Override
    public void saveAccount(Account account) {
        decoratedDAO.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        decoratedDAO.updateAccount(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {
        return decoratedDAO.loadAccount(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        return decoratedDAO.getAccounts();
    }
}
