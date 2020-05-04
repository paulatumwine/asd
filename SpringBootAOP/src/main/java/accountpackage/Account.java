package accountpackage;

public class Account {
	private String accountNumber;
	private Customer customer;
	public Account(String accountNumber, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + "]";
	}
	
	

}
