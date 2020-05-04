package edu.miu.cs.cs525.parte.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class CustomerDAOMock implements ICustomerDAO {
    @Autowired
    ILogger logger;

    @Override
    public void save(Customer customer) {
        logger.log("test saving customer " + customer);
    }
}
