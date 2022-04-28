package com.trevari.zipkinpoc.consumer;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.trevari.zipkinpoc.publish.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private final Publisher publisher;

    public Consumer(Publisher publisher) {
        this.publisher = publisher;
    }

    @SqsListener("${app.queue.name}")
    public void receiveMessage(String message, @Headers Map<String, MessageAttributeValue> sqsHeaders) {
        logger.info("[우편 수신]");
        logger.info("[내용] " + message);

        publisher.send(message);
        logger.info("[우편을 배송합니다]");
    }
}
