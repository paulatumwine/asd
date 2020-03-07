package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationFilter {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("A234", "Iphone 10", 850.0, true));
		products.add(new Product("A235", "Iphone 11", 1050.0, false));
		products.add(new Product("A236", "Iphone 9", 650.0, true));
		products.add(new Product("A238", "Iphone 8", 425.0, true));
				
		System.out.println("Available products:");
		List<Product> availableProducts = products.stream()
				  .filter(p -> p.isAvailable())
				  .collect(Collectors.toList());

		availableProducts.forEach(p -> System.out.println(p));
        
        System.out.println("Products with price > 800:");
		List<Product> expensiveProducts = products.stream()
				  .filter(p -> p.getPrice() > 800)
				  .collect(Collectors.toList());
		
		expensiveProducts.forEach(p -> System.out.println(p));
        
        System.out.println("Available products with price > 800:");
		List<Product> availableExpensiveProducts = products.stream()
				  .filter(p ->  p.isAvailable())
				  .filter(p -> p.getPrice() > 800)
				  .collect(Collectors.toList());
		
		availableExpensiveProducts.forEach(p -> System.out.println(p));
	}
}
