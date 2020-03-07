package removing.with.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationForEachException {

	public static void main(String[] args){
		List<String> alphabet = new ArrayList<String>();
		alphabet.add("a");
		alphabet.add("b");
		alphabet.add("c");
         
        for(String letter: alphabet){
			if (letter.equals("c"))
				alphabet.remove(letter);

        }
    }
}
