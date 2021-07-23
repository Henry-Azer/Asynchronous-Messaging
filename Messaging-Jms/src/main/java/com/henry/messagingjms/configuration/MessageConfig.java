package com.henry.messagingjms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

import com.henry.messagingdata.entity.Order;

@Configuration
public class MessageConfig {

    @Bean
    protected MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter jackson2MessageConverter
                = new MappingJackson2MessageConverter();

        jackson2MessageConverter.setTypeIdPropertyName("_typeId");

        Map<String, Class<?>> typeIdMapping = new HashMap<>();
        typeIdMapping.put("order", Order.class);

        jackson2MessageConverter.setTypeIdMappings(typeIdMapping);

        return jackson2MessageConverter;
    }
}
