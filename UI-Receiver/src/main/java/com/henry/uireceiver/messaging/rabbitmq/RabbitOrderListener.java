package com.henry.uireceiver.messaging.rabbitmq;

import com.henry.uireceiver.entity.Order;
import com.henry.uireceiver.ui.OrderUI;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("rabbitmq-listener")
@Service
public class RabbitOrderListener {

    private final OrderUI orderUI;

    @Autowired
    public RabbitOrderListener(OrderUI orderUI) {
        this.orderUI = orderUI;
    }

    @RabbitListener(queues = "taco.order.queue")
    public void receiveOrder(Order order) {
        orderUI.displayOrder(order);
    }
}
