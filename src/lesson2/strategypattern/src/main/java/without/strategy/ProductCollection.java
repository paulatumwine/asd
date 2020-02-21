package lesson2.strategypattern.src.main.java.without.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCollection {
	private List<Product> products = new ArrayList<Product>();
	
	public void addproduct(Product product) {
		products.add(product);
	}
	
	public boolean removeProduct(String productNumber) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getProductNumber().contentEquals(productNumber)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	
	public void bubbleSort() {
		System.out.println("peform bubblesort");
	}
	
	public void insertionSort() {
		System.out.println("peform insertionsort");
	}

	public void quickSort() {
		System.out.println("peform quicksort");
	}
}
