package edu.miu.cs.cs525.parte;

import edu.miu.cs.cs525.parte.customers.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PartEApplication implements CommandLineRunner {

    @Autowired ICustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(PartEApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerService.addCustomer("Frank Brown", "fbrown@acme.com",
                "mainstreet 5", "Chicago", "60613");
    }
}
