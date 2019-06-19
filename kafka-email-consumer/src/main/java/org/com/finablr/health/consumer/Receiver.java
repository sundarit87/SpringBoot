package org.com.finablr.health.consumer;

import java.util.concurrent.CountDownLatch;

import org.com.finablr.health.entity.dto.UserDto;
import org.com.finablr.health.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;

    //@KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    @KafkaListener(topics = "user_send")
    public void receive(UserDto payload) {
        LOGGER.info("received payload='{}'", payload.toString());
        emailService.sendSimpleMessage(payload);
        latch.countDown();
    }
}
