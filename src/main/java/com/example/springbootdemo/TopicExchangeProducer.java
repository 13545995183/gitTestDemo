package com.example.springbootdemo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class TestSendMessageController {
    @Autowired
    private AmqpTemplate rabbitMQTemplate;

    public void send(String msg, String routingKey) {
        rabbitMQTemplate.convertAndSend(DirectRabbitConfig.topicExchangeName, routingKey, msg);
    }
}
