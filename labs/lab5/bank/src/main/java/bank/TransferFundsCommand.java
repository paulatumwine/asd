package bank;

import bank.service.IAccountService;

public class TransferFundsCommand implements Command {

    IAccountService accountService;
    long fromAccountNumber;
    long toAccountNumber;
    double amount;
    String description;

    public TransferFundsCommand(IAccountService accountService, long fromAccountNumber, long toAccountNumber, double amount, String description) {
        this.accountService = accountService;
        this.toAccountNumber = toAccountNumber;
        this.fromAccountNumber = fromAccountNumber;
        this.amount = amount;
        this.description = description;
    }

    public void execute() {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
    }

    public void unExecute() {
        accountService.transferFunds(toAccountNumber, fromAccountNumber, amount, description);
    }
}
