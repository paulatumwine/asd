package customers;

public class CustomerDAO implements ICustomerDAO {
    ILogger logger = new Logger();

    public void save(Customer customer) {
        logger.log("saving customer " + customer);
    }
}
