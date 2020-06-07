package com.listener;


import com.config.JmsConfig;
import com.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;


@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("I Got a Message!!!!!");

        System.out.println(helloWorldMessage);
//        6.1 если сейчас запустить приложение, то к двум предыдушим сообюдением добавить сообщение I Got a Message!!!!!
//        и сообщение, которое "закодировано" в helloWorldMessage
//        пример ->example3.png



        // uncomment and view to see retry count in debugger
       // throw new RuntimeException("foo");

    }

}
