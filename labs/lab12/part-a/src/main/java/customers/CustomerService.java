package customers;

public class CustomerService implements ICustomerService {
    ICustomerDAO customerDAO = new CustomerDAO();
    IEmailSender emailSender = new EmailSender();

    public void addCustomer(String name, String email, String street, String city, String zip) {
        Customer customer = new Customer(name, email, new Address(street, city, zip));
        customerDAO.save(customer);
        emailSender.sendEmail("Sending email for customer " + customer);
    }
}
