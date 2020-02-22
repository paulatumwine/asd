package lab2.bank.src.main.java.bank.domain;

public class SavingsAccount extends Account {

    public SavingsAccount(long accountnr) {
        super(accountnr);
    }

    @Override
    public double calculateInterest() {
        double balance = getBalance();
        if (balance < 1000)
            return .01 * balance;
        else if (balance > 1000 && balance < 5000)
            return .02 * balance;
        else
            return .04 * balance;
    }
}
