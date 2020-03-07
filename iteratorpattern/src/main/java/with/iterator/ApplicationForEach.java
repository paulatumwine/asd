package with.iterator;

import java.util.ArrayList;
import java.util.List;

public class ApplicationForEach {

	public static void main(String[] args){
		List<String> alphabet = new ArrayList<String>();
		alphabet.add("a");
		alphabet.add("b");
		alphabet.add("c");
         
        for(String letter: alphabet){
            System.out.println(letter.toUpperCase());
        }
    }
}
