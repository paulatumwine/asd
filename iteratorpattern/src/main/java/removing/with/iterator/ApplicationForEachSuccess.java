package removing.with.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationForEachSuccess {

	public static void main(String[] args){
		String toBeRemoved = null;
		List<String> alphabet = new ArrayList<String>();
		alphabet.add("a");
		alphabet.add("b");
		alphabet.add("c");
         
        for(String letter: alphabet){
			if (letter.equals("c"))
				toBeRemoved=letter;
        }
        alphabet.remove(toBeRemoved);
        
        for(String letter: alphabet){
            System.out.println(letter.toUpperCase());
        }

    }
}
