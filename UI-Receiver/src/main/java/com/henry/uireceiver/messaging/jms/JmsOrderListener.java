package com.henry.uireceiver.messaging.jms;

import com.henry.uireceiver.entity.Order;
import com.henry.uireceiver.ui.OrderUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Profile("jms-listener")
@Service
public class JmsOrderListener {

    private final OrderUI orderUI;

    @Autowired
    public JmsOrderListener(OrderUI orderUI) {
        this.orderUI = orderUI;
    }

    @JmsListener(destination = "taco.order.queue")
    public void receiveOrder(Order order) {
        orderUI.displayOrder(order);
    }
}
