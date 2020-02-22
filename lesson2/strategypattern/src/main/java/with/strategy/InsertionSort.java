package lesson2.strategypattern.src.main.java.with.strategy;

public class InsertionSort extends SortStrategy{
	public InsertionSort(ProductCollection productCollection) {
		super(productCollection);
	}

	@Override
	void sort() {
		System.out.println("peform insertionsort");		
	}
}