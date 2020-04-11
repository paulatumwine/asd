package file.io.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LineCountInputStream extends FilterInputStream {
	int lineCount = 0;


	protected LineCountInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		if (c != -1 && c==10 ) //carriage return = 10
			lineCount++;;
		return c;
	}
	

	public int getLineCount() {
		return lineCount;
	}	
}

