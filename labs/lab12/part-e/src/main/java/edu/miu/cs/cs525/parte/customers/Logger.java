package edu.miu.cs.cs525.parte.customers;

import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger {

    public void log(String message) {
        System.out.println(message);
    }
}
