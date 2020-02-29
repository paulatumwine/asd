package observer.pull;

public class StockNotifier extends Observer {
	private StockService stockService;

	public StockNotifier(StockService stockService) {
		super(stockService);
	}

	public void handleStockChange(Stock stock) {
		System.out.println("StockNotifier handle stock :" + stock);
	}

	@Override
	public void update() {
		Stock stock = stockService.getLastChangedStock();
		handleStockChange(stock);
	}

}
