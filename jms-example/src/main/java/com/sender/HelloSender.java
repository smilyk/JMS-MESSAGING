package com.sender;

import com.config.JmsConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;


/**
 * Created by jt on 2019-07-17.
 */
@RequiredArgsConstructor
@Component
public class HelloSender {
    //      5.2
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;


    //  устанавливаем периодичность отправки - раз в 2 сек
    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
//        5.1
        System.out.println("I am sending message");
//        если сейчас запустить приложение - то мы увидим, что каждые 2 сек есть сообщение "I am sending message"
//        пример -> example1.png

//        5.2
//        строим сообщение, которое хотим отправить
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!")
                .build();
//        5.2
//        конвертируем и отправляем
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
        System.out.println("Message sent!");
//        если сейчас запустить приложение - то мы увидим, что каждые 2 сек есть сообщение "I am sending message",
//        а после него - сообщение "Message sent!"
//        пример -> example2.png

    }
//          7
@Scheduled(fixedRate = 2000)
public void sendandReceiveMessage() throws JMSException {

    HelloWorldMessage message = HelloWorldMessage
            .builder()
            .id(UUID.randomUUID())
            .message("Hello")
            .build();

    Message receviedMsg = jmsTemplate.sendAndReceive(JmsConfig.MY_SEND_RCV_QUEUE, new MessageCreator() {
        @Override
        public Message createMessage(Session session) throws JMSException {
            Message helloMessage = null;

            try {
                helloMessage = session.createTextMessage(objectMapper.writeValueAsString(message));
                helloMessage.setStringProperty("_type", "com.model.HelloWorldMessage");

                System.out.println("Sending Hello");

                return helloMessage;

            } catch (JsonProcessingException e) {
                throw new JMSException("boom");
            }
        }
    });

    System.out.println(receviedMsg.getBody(String.class));

}

}
