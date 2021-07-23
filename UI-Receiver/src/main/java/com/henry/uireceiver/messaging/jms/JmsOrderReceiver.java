package com.henry.uireceiver.messaging.jms;

import com.henry.uireceiver.entity.Order;
import com.henry.uireceiver.services.OrderReceiverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Profile("jms-template")
@Service
public class JmsOrderReceiver implements OrderReceiverServices {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Order orderReceiver() {
        return (Order) jmsTemplate.receiveAndConvert("taco.order.queue");
    }

}
