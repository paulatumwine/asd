package lab2.templatemethod.src.main.java.with.templatemethod;

import lab2.templatemethod.src.main.java.without.templatemethod.Customer;
import lab2.templatemethod.src.main.java.without.templatemethod.VisaCard;


public class Application {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Frank Brown", "fbrown@gmail.com");
		VisaCard visaCard = new VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112);
		Visa visa = new Visa(visaCard);
		visa.proccessPayment(125.75, "USD", customer1);
		
		System.out.println("------------------------------------");
		
		Customer customer2 = new Customer("John Doe", "jdoe@gmail.com");
		PayPal payPal = new PayPal("jdoe@gmail.com");
		payPal.proccessPayment(175000.0, "INR", customer2);

	}
}
