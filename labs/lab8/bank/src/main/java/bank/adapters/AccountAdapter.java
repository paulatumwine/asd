package bank.adapters;

import bank.domain.Account;
import bank.dto.AccountDTO;

public class AccountAdapter implements IAccountAdapter {

    @Override
    public AccountDTO getAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountnumber(account.getAccountnumber());
        accountDTO.setCustomer(account.getCustomer());
        accountDTO.setEntryList(account.getEntryList());
        return accountDTO;
    }

    @Override
    public Account getAccount(AccountDTO accountDTO) {
        Account account = new Account(accountDTO.getAccountnumber());
        account.setCustomer(accountDTO.getCustomer());
        return account;
    }
}
