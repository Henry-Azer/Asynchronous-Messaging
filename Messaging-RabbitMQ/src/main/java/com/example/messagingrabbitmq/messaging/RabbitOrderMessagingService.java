package com.example.messagingrabbitmq.messaging;

import com.henry.messagingdata.entity.Order;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService{

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        rabbitTemplate.convertAndSend("taco.order.queue", order,
                message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            messageProperties.setHeader("X_ORDER_SOURCE", "WEB");

            return message;
        });
    }
}
