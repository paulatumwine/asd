package own.iterator;

import java.util.Iterator;
import java.util.function.Predicate;

public class ApplicationFilter {

	public static void main(String[] args) {
		ProductCollection productCollection = new ProductCollection();
		productCollection.addProduct(new Product("A234", "Iphone 10", 850.0, true));
		productCollection.addProduct(new Product("A235", "Iphone 11", 1050.0, false));
		productCollection.addProduct(new Product("A236", "Iphone 9", 650.0, true));
		productCollection.addProduct(new Product("A238", "Iphone 8", 425.0, true));
		
		System.out.println("Available products:");
		Predicate<Product> availablepredicate = p -> p.isAvailable();
        Iterator<Product> filterIterator = productCollection.filterIterator(availablepredicate);
        while (filterIterator.hasNext()) {
        	System.out.println(filterIterator.next());
        }
        
        System.out.println("Products with price > 800:");
		Predicate<Product> pricepredicate = p -> p.getPrice() > 800;
        filterIterator = productCollection.filterIterator(pricepredicate);
        while (filterIterator.hasNext()) {
        	System.out.println(filterIterator.next());
        }
        
        System.out.println("Available products with price > 800:");
		Predicate<Product> availablepricepredicate = p -> p.getPrice() > 800 && p.isAvailable();
        filterIterator = productCollection.filterIterator(availablepricepredicate);
        while (filterIterator.hasNext()) {
        	System.out.println(filterIterator.next());
        }
	}

}
