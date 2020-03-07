package bank;

import bank.domain.Account;

public interface IObserver {
  public void update(Account account);
}
