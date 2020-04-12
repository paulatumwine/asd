package bank.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AbstractFactory {
	private IFactory factory;
	
	public AbstractFactory() {
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			Properties prop = new Properties();
			// load the properties file
			prop.load(new FileInputStream(rootPath + "/config.properties"));
			// get the property value
			String environment = prop.getProperty("environment");

			if (environment.equals("production")) {
				factory= new ProductionFactory();
			} else if (environment.equals("test")) {
				factory= new MockFactory();
			} else {
				System.out.println("environment property not set correctly");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public IFactory getFactoryInstance() {
	  return factory;
	}
}
