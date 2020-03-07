package own.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ProductCollection {
	private List<Product> products = new ArrayList<>();
	
	public void addProduct(Product product){
		products.add(product);
	}
	
	public Iterator<Product> reverseIterator(){
		return new ReverseIterator<Product>(products);
	}
	
	public Iterator<Product> filterIterator(Predicate<Product> predicate){
		return new FilterIterator<Product>(products, predicate);
	}

}
