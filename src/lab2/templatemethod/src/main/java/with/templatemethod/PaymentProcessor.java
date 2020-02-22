package lab2.templatemethod.src.main.java.with.templatemethod;

import lab2.templatemethod.src.main.java.without.templatemethod.Customer;

public abstract class PaymentProcessor {

	protected void proccessPayment(double amount, String currency, Customer customer) {
		double dollarAmount = amount;

		if (currency.contentEquals("EUR")) { // European Euro
			dollarAmount = amount * 1.1;
			System.out.println("Convert "+amount+" "+currency+" to US dollars");

		}
		if (currency.contentEquals("INR")) { // Indian Rupee
			dollarAmount = amount * 0.014;
			System.out.println("Convert "+amount+" "+currency+" to US dollars");

		}

		boolean validation = validate();
		if (validation) {
			performPayment(dollarAmount);
			notifyCustomer(customer);
		}

	}

	protected abstract boolean validate();
	protected abstract void performPayment(double dollarAmount);
	protected abstract void notifyCustomer(Customer customer);
}
