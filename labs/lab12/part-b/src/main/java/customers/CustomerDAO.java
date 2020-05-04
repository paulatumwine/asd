package customers;

public class CustomerDAO implements ICustomerDAO {
    ILogger logger;

    public CustomerDAO(ILogger logger) {
        this.logger = logger;
    }

    public void save(Customer customer) {
        logger.log("saving customer " + customer);
    }
}
