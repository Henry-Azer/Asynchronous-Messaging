package com.henry.uireceiver.ui;

import com.henry.uireceiver.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderUI {

  public void displayOrder(Order order) {
    log.info("RECEIVED ORDER:  " + order);
  }
  
}
