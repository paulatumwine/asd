package stock;

public class StockChangeEvent {
	private String stockName;
	private double newValue;

	public StockChangeEvent(String stockName, double newValue) {
		super();
		this.stockName = stockName;
		this.newValue = newValue;
	}

	@Override
	public String toString() {
		return "StockChangeEvent [stockName=" + stockName + ", newValue=" + newValue + "]";
	}

}
