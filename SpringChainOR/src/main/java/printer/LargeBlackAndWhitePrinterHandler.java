package printer;

import org.springframework.stereotype.Component;
import printer.PrintProperties.Color;
import printer.PrintProperties.Size;

@Component
public class LargeBlackAndWhitePrinterHandler implements PrinterHandler{

	public void print(String content){
		System.out.println("Large black and white printer prints: "+content);
	}

	public boolean handle(PrintProperties printerProperties, String content) {
		if (isBlackAndWhitePrinter(printerProperties ) && isLargePrinter(printerProperties)) {
			print(content);
			return true;
		}
		return false;
	}

	private boolean isLargePrinter(PrintProperties PrinterProperties) {
		return PrinterProperties.getSize()==Size.LARGE;
	}

	private boolean isBlackAndWhitePrinter(PrintProperties PrinterProperties) {
		return PrinterProperties.getColor()==Color.BLACKANDWHITE;
	}
}
