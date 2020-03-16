package bank;

import bank.service.IAccountService;

public class DepositCommand implements Command {

    IAccountService accountService;
    long accountNumber;
    double amount;

    public DepositCommand(IAccountService accountService, long accountNumber, double amount) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public void execute() {
        accountService.deposit(accountNumber, amount);
    }

    public void unExecute() {
        accountService.withdraw(accountNumber, amount);
    }
}
