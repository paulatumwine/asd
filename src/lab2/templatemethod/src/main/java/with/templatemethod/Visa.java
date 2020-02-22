package lab2.templatemethod.src.main.java.with.templatemethod;

import lab2.templatemethod.src.main.java.without.templatemethod.Customer;
import lab2.templatemethod.src.main.java.without.templatemethod.VisaCard;

public class Visa extends PaymentProcessor {

    VisaCard visaCard;

    public Visa(VisaCard visaCard) {
        this.visaCard = visaCard;
    }

    @Override
    protected boolean validate() {
        // logic to validate visa card
        System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
        return true;
    }

    @Override
    protected void performPayment(double dollarAmount) {
        // logic to perform payment visa card
        System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber()
                + " and amount $" + dollarAmount);
    }

    @Override
    protected void notifyCustomer(Customer customer) {
        // logic to notify customer
        System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
                + " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
    }
}
