package lab2.templatemethod.src.main.java.with.templatemethod;

import lab2.templatemethod.src.main.java.without.templatemethod.Customer;

public class PayPal extends PaymentProcessor {

    String paypalAddress;

    public PayPal(String paypalAddress) {
        this.paypalAddress = paypalAddress;
    }

    @Override
    protected boolean validate() {
        // logic to validate paypal address
        System.out.println("Validate paypal address "+paypalAddress);
        return true;
    }

    @Override
    protected void performPayment(double dollarAmount) {
        // logic to perform paypal payment
        System.out.println("Perform payment with paypal address "+paypalAddress+" and amount $"+dollarAmount);
    }

    @Override
    protected void notifyCustomer(Customer customer) {
        // logic to notify customer
        System.out.println("Notify customer "+customer.getName()+" with email "+customer.getEmail()+" about paypal payment to address "+paypalAddress);
    }
}
