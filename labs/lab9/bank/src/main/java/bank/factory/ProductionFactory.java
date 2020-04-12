package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.AccountDAOLogger;
import bank.dao.IAccountDAO;
import bank.email.EmailSender;
import bank.email.IEmailSender;

public class ProductionFactory implements IFactory {
    @Override
    public IEmailSender getEmailSender() {
        return EmailSender.getInstance();
    }

    @Override
    public IAccountDAO getAccountDao() {
        return new AccountDAOLogger(new AccountDAO());
    }
}
