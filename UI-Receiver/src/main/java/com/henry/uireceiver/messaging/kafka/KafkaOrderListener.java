package com.henry.uireceiver.messaging.kafka;


import com.henry.uireceiver.entity.Order;
import com.henry.uireceiver.ui.OrderUI;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("kafka-listener")
@Slf4j
@Service
public class KafkaOrderListener {

    private final OrderUI orderUI;

    @Autowired
    public KafkaOrderListener(OrderUI orderUI) {
        this.orderUI = orderUI;
    }

    public void orderReceiver(Order order, ConsumerRecord<String, Order> record) {
        log.info("Received from partition {} with timestamp {}",
                record.partition(), record.timestamp());

        orderUI.displayOrder(order);
    }
}
