package own.iterator;

import java.util.Iterator;

public class Application {

	public static void main(String[] args) {
		ProductCollection productCollection = new ProductCollection();
		productCollection.addProduct(new Product("A234", "Iphone 10", 850.0, true));
		productCollection.addProduct(new Product("A235", "Iphone 11", 1050.0, false));
		productCollection.addProduct(new Product("A236", "Iphone 9", 650.0, true));
		productCollection.addProduct(new Product("A238", "Iphone 8", 425.0, true));
		
		
        Iterator<Product> reverseIterator = productCollection.reverseIterator();
        while (reverseIterator.hasNext()) {
        	System.out.println(reverseIterator.next());
        }
	}

}
