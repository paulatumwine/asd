package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config.xml");
        ICustomerService customerService = context.getBean("customerService",
                ICustomerService.class);

        customerService.addCustomer("Frank Brown", "fbrown@acme.com",
                "mainstreet 5", "Chicago", "60613");
    }
}
