package ec.com.dinersclub.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    @Autowired
    private ApplicationContext context;

    public Controller(ApplicationContext context) {
        this.context = context;
    }

    public void sendMgs(String msg) {
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", msg);
    }

}
