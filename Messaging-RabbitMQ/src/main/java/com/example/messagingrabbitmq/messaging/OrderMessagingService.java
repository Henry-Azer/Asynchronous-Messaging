package com.example.messagingrabbitmq.messaging;

import com.henry.messagingdata.entity.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
