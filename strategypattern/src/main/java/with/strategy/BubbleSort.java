package lesson2.strategypattern.src.main.java.with.strategy;

public class BubbleSort extends SortStrategy{
	public BubbleSort(ProductCollection productCollection) {
		super(productCollection);
	}

	@Override
	void sort() {
		System.out.println("peform bubblesort");		
	}
}
