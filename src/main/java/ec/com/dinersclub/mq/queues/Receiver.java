package ec.com.dinersclub.mq.queues;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox")
    public void receiveMessage(String email) {
        System.out.println("Received <" + email + ">");
    }

}
