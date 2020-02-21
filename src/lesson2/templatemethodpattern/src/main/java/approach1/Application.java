package lesson2.templatemethodpattern.src.main.java.approach1;


public class Application {

	public static void main(String[] args) {
		FileLogger fileLogger = new FileLogger();
		LogMessage message = new LogMessage("cannot send email", "smpt server smtp.acme.com cannot be reached", LogMessage.LogLevel.ERROR);
		fileLogger.log(message);
		System.out.println("------------------------");
		DatabaseLogger databaseLogger = new DatabaseLogger();
		LogMessage message2 = new LogMessage("subject is empty", "this email has no subject, emails should have a subject", LogMessage.LogLevel.INFO);
		databaseLogger.log(message2);

	}
}
