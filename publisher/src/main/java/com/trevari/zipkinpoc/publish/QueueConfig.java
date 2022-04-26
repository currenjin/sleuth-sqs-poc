package com.trevari.zipkinpoc.publish;

import brave.Tracer;
import brave.Tracing;
import brave.instrumentation.aws.sqs.SqsMessageTracing;
import brave.propagation.aws.AWSPropagation;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    Tracer tracer;

    public QueueConfig(Tracer tracer) {
        this.tracer = tracer;
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        Tracing current = Tracing.current();
        SqsMessageTracing sqsMessageTracing = SqsMessageTracing.create(current);

        AmazonSQSAsync client = AmazonSQSAsyncClientBuilder.standard()
                .withRegion(Regions.AP_NORTHEAST_2)
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .withRequestHandlers(sqsMessageTracing.requestHandler())
                .build();

        return new QueueMessagingTemplate(client);
    }

}