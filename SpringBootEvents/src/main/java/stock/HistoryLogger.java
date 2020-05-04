package stock;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HistoryLogger {
	  @Async
	  @EventListener
	  public void log(StockChangeEvent stockChangeEvent) {
	    System.out.println("HistoryLogger received event :" + stockChangeEvent);;
	  }
}
