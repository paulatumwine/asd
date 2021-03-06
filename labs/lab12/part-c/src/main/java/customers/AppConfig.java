package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService(ICustomerDAO customerDAO, IEmailSender emailSender) {
        return new CustomerService(customerDAO, emailSender);
    }

    @Bean
    public CustomerDAO customerDAO(Logger logger) {
        return new CustomerDAO(logger);
    }

    @Bean
    public EmailSender emailSender(Logger logger) {
        return new EmailSender(logger);
    }

    @Bean
    public Logger logger() {
        return new Logger();
    }
}
