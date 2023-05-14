package com.demo.service;

import com.demo.dto.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "demoraj", groupId = "my_consumer_group_1")
    public void consume(Product product){
        System.out.printf("product : "+ product);
    }
}
