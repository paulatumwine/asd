package customers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementService {

    @EventListener
    public void handleNewCustomerAds(NewCustomerEvent newCustomerEvent) {
        System.out.println("New customer information: " + newCustomerEvent.getCustomer());
    }
}
