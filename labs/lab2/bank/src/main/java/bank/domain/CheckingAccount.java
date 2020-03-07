package lab2.bank.src.main.java.bank.domain;

public class CheckingAccount extends Account {

    public CheckingAccount(long accountnr) {
        super(accountnr);
    }

    @Override
    public double calculateInterest() {
        double balance = getBalance();
        return (balance < 1000) ? .015 * balance : .025 * balance;
    }
}
