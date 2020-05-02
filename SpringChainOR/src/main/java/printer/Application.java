package printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import printer.PrintProperties.Color;
import printer.PrintProperties.Size;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PrintingService printingService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		printingService.print(new PrintProperties(Size.SMALL, Color.COLOR), "Hello world");
		printingService.print(new PrintProperties(Size.LARGE, Color.COLOR), "Hello world");
		printingService.print(new PrintProperties(Size.SMALL, Color.BLACKANDWHITE), "Hello world");
		printingService.print(new PrintProperties(Size.LARGE, Color.BLACKANDWHITE), "Hello world");
	}
}
