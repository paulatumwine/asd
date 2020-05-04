package edu.miu.cs.cs525.parte.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements IEmailSender {
    String outgoingMailServer = "smtp.acme.com";
    @Autowired private ILogger logger;

    public EmailSender(ILogger logger) {
        this.logger = logger;
    }

    public void sendEmail(String message) {
        logger.log(message);
    }
}
