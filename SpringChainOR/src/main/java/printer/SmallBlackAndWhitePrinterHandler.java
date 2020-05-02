package printer;

import org.springframework.stereotype.Component;
import printer.PrintProperties.Color;
import printer.PrintProperties.Size;

@Component
public class SmallBlackAndWhitePrinterHandler implements PrinterHandler{

	public void print(String content){
		System.out.println("Large black and white printer prints: "+content);
	}

	public boolean handle(PrintProperties printerProperties, String content) {
		if (isBlackAndWhitePrinter(printerProperties ) && isSmallPrinter(printerProperties)) {
			print(content);
			return true;
		}
		return false;
	}

	private boolean isSmallPrinter(PrintProperties PrinterProperties) {
		return PrinterProperties.getSize()==Size.SMALL;
	}

	private boolean isBlackAndWhitePrinter(PrintProperties PrinterProperties) {
		return PrinterProperties.getColor()==Color.BLACKANDWHITE;
	}
}
