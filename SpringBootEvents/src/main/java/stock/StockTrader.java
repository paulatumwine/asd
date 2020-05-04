package stock;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StockTrader {
	  @Async
	  @EventListener
	  public void trade(StockChangeEvent stockChangeEvent) {
	    System.out.println("StockTrader received event :" + stockChangeEvent);;
	  }
}
