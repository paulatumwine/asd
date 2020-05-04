package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired ICustomerDAO customerDAO;
    @Autowired IEmailSender emailSender;

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
