package lesson2.strategypattern.src.main.java.with.strategy;

public class QuickSort extends SortStrategy{
	public QuickSort(ProductCollection productCollection) {
		super(productCollection);
	}

	@Override
	void sort() {
		System.out.println("peform quicksort");		
	}
}


