package bank.factory;

import bank.dao.IAccountDAO;
import bank.dao.MockAccountDAO;
import bank.email.IEmailSender;
import bank.email.MockEmailSender;

public class MockFactory implements IFactory {
    @Override
    public IEmailSender getEmailSender() {
        return new MockEmailSender();
    }

    @Override
    public IAccountDAO getAccountDao() {
        return new MockAccountDAO();
    }
}
