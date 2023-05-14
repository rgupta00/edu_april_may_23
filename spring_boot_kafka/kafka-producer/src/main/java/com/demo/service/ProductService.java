package com.demo.service;

import com.demo.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    public void produce(Product product){
        System.out.printf("message is send to the kafka server");
        product.setId(UUID.randomUUID().toString());
        kafkaTemplate.send("demoraj",product );
    }
}
