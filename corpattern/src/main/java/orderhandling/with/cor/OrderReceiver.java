package orderhandling.with.cor;

import orderhandling.without.cor.FileReader;

import java.io.IOException;

public class OrderReceiver {
	private OrderHandler orderHandler;
	
	public void setOrderHandler(OrderHandler orderHandler) {
		this.orderHandler = orderHandler;
	}

	public void receiveOrder(String fileName) throws IOException {
		FileReader fileReader = new FileReader();
		String orderContent = fileReader.getStringFromFile(fileName);
		handleOrder(orderContent);
	}

	public void handleOrder(String orderContent) {
		orderHandler.handleOrder(orderContent);
	}
}
