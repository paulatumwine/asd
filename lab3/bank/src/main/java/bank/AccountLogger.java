package bank;

import bank.domain.Account;

public class AccountLogger implements IObserver {
    @Override
    public void update(Account account) {
        log(account);
    }

    private void log(Account account) {
        System.out.println("New account balance is: " + account.getBalance());
    }
}
