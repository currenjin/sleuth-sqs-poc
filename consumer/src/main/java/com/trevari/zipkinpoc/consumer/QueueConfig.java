package com.trevari.zipkinpoc.consumer;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

}