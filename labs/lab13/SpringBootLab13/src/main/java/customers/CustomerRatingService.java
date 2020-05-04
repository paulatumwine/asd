package customers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerRatingService {

    @EventListener
    public void handleNewCustomerRatings(NewCustomerEvent newCustomerEvent) {
        System.out.println("New customer information: " + newCustomerEvent.getCustomer());
    }
}
