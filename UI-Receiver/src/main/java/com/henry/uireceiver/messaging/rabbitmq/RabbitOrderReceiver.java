package com.henry.uireceiver.messaging.rabbitmq;

import com.henry.uireceiver.entity.Order;
import com.henry.uireceiver.services.OrderReceiverServices;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("rabbitmq-template")
@Service
public class RabbitOrderReceiver implements OrderReceiverServices {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Order orderReceiver() {
        return (Order) rabbitTemplate.receiveAndConvert("taco.order.queue");
    }
}
