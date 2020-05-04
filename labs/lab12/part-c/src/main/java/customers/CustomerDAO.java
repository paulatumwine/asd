package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO implements ICustomerDAO {
    @Autowired ILogger logger;

    public CustomerDAO(ILogger logger) {
        this.logger = logger;
    }

    public void save(Customer customer) {
        logger.log("saving customer " + customer);
    }
}
