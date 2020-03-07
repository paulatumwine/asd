package streams;

public class Product {
	private String number;
	private String name;
	private double price;
	private boolean available;

	public Product(String number, String name, double price, boolean available) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.available = available;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + ", available=" + available + "]";
	}
	
	

}
