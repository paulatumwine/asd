package bank.adapters;

import bank.domain.Account;
import bank.dto.AccountDTO;

public interface IAccountAdapter {
    public AccountDTO getAccountDTO(Account account);
    public Account getAccount(AccountDTO account);
}
