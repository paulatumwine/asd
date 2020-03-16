package bank;

import bank.service.IAccountService;

public class WithdrawCommand implements Command {

    IAccountService accountService;
    long accountNumber;
    double amount;

    public WithdrawCommand(IAccountService accountService, long accountNumber, double amount) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public void execute() {
        accountService.withdraw(accountNumber, amount);
    }

    public void unExecute() {
        accountService.deposit(accountNumber, amount);
    }
}
