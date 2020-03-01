package bank;

import bank.domain.Account;

public class SMSSender implements IObserver {
    @Override
    public void update(Account account) {
        sendSMS(account);
    }

    private void sendSMS(Account account) {
        System.out.println("New account balance is: " + account.getBalance());
    }
}
