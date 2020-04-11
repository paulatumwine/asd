package file.io.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ToUppercaseInputStream extends FilterInputStream {

	protected ToUppercaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		if (c != -1)
			c = Character.toUpperCase((char)c);
		return c;
	}
}

