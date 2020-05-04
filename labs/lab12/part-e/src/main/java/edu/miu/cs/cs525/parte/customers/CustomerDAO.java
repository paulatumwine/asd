package edu.miu.cs.cs525.parte.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("production")
public class CustomerDAO implements ICustomerDAO {
    @Autowired ILogger logger;

    public CustomerDAO(ILogger logger) {
        this.logger = logger;
    }

    public void save(Customer customer) {
        logger.log("saving customer " + customer);
    }
}
