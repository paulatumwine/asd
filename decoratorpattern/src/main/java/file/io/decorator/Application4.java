package file.io.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Application4 {

	public static void main(String[] args) {
		int c;
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			LineCountInputStream inputStream = new LineCountInputStream(new ToUppercaseInputStream(new BufferedInputStream(new FileInputStream(rootPath + "/input.txt"))));

			while ((c = inputStream.read()) >= 0) {
				System.out.print((char) c);
			}
			System.out.println("");
			System.out.println("This file contains "+inputStream.getLineCount()+" lines");
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
