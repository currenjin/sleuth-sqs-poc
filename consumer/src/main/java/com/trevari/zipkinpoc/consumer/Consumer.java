package com.trevari.zipkinpoc.consumer;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @SqsListener("${app.queue.name}")
    public void receiveMessage(String message, @Headers Map<String, MessageAttributeValue> sqsHeaders) {
        logger.info("Message received");

        logger.info("Message content: " + message);
        logger.info("Message headers: " + sqsHeaders);
    }
}
