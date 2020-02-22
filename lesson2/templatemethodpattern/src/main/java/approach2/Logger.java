package lesson2.templatemethodpattern.src.main.java.approach2;


public abstract class Logger {
    protected String serializeMessage(LogMessage message) {
        System.out.println("Serializing message");
        return message.toString();
    }

}
