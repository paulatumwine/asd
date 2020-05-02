package printer;

public class PrintProperties {
	enum Size {
		SMALL, LARGE
	}

	enum Color {
		BLACKANDWHITE, COLOR
	}

	private Size size;
	private Color color;

	public PrintProperties(Size size, Color color) {
		super();
		this.size = size;
		this.color = color;
	}

	public PrintProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
