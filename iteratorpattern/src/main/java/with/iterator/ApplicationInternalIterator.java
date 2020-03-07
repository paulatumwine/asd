package with.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationInternalIterator {

	public static void main(String[] args) {
		List<String> alphabet = new ArrayList<String>();
		alphabet.add("a");
		alphabet.add("b");
		alphabet.add("c");

		alphabet.forEach(l -> System.out.println(l.toUpperCase()));
	}
}
