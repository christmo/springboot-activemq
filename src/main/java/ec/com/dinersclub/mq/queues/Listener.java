package ec.com.dinersclub.mq.queues;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Listener {

    @JmsListener(destination = "t24")
    @SendTo("outbound.queue")
    public String receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = null;
        System.out.println("Received message " + jsonMessage);
        //String response = null;
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
            //Map map = new Gson().fromJson(message, Map.class);
            //response = "Hello " + map.get("name");
        }
        //return response;
        return messageData;
    }

}
