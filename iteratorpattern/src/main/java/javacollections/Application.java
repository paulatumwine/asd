package javacollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Application {
	public static void main(String[] args) {
		Collection<String> col1 = new ArrayList<>();
		col1.add("a");
		col1.add("b");
		col1.add("c");
		Collection<String> col2 = new HashSet<>();
		col1.add("a");
		col1.add("b");
		col1.add("c");
		Collection<String> col3 = new LinkedList<>();
		col1.add("a");
		col1.add("b");
		col1.add("c");
		printCollection(col1);
		printCollection(col2);
		printCollection(col3);
	}
	
	public static void printCollection(Collection<String> collection) {
		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
