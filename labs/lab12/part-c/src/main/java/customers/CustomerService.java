package customers;

public class CustomerService implements ICustomerService {
    ICustomerDAO customerDAO;
    IEmailSender emailSender;

    public CustomerService(ICustomerDAO customerDAO, IEmailSender emailSender) {
        this.customerDAO = customerDAO;
        this.emailSender = emailSender;
    }

    public void addCustomer(String name, String email, String street, String city, String zip) {
        Customer customer = new Customer(name, email, new Address(street, city, zip));
        customerDAO.save(customer);
        emailSender.sendEmail("Sending email for customer " + customer);
    }

    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void setEmailSender(IEmailSender emailSender) {
        this.emailSender = emailSender;
    }
}
