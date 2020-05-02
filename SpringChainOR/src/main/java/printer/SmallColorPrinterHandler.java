package printer;

import org.springframework.stereotype.Component;
import printer.PrintProperties.Color;
import printer.PrintProperties.Size;

@Component
public class SmallColorPrinterHandler implements PrinterHandler{

	public void print(String content){
		System.out.println("Small color printer prints: "+content);
	}

	public boolean handle(PrintProperties printerProperties, String content) {
		if (isColorPrinter(printerProperties ) && isSmallPrinter(printerProperties)) {
			print(content);
			return true;
		}
		return false;
	}

	private boolean isSmallPrinter(PrintProperties PrinterProperties) {
		return PrinterProperties.getSize()==Size.SMALL;
	}

	private boolean isColorPrinter(PrintProperties PrinterProperties) {
		return PrinterProperties.getColor()==Color.COLOR;
	}
}
