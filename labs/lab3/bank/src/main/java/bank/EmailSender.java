package bank;

import bank.domain.Account;

public class EmailSender implements IObserver {
    @Override
    public void update(Account account) {
        sendEmail(account);
    }

    private void sendEmail(Account account) {
        System.out.println("New account balance is: " + account.getBalance());
    }
}
