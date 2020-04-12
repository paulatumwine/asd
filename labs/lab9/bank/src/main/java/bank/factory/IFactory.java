package bank.factory;

import bank.dao.IAccountDAO;
import bank.email.IEmailSender;

public interface IFactory {
    IEmailSender getEmailSender();
    IAccountDAO getAccountDao();
}
