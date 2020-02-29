package observer.pull;

public abstract class Observer {
	private StockService stockService;

	public Observer(StockService stockService) {
		this.stockService = stockService;
	}
	
	public abstract void update();
}
