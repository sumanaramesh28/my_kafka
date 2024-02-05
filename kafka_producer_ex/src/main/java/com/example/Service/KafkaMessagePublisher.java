package com.example.Service;

import org.apache.kafka.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMessageToTopic(String message) {
        //template.send("my_topic",message);
        CompletableFuture<SendResult<String, Object>> future;
        future = template.send("topic_check", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent Message [" + message + "] with offset [" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send Message [" + message + "] due to [" + ex.getMessage() + "]");
            }

        });
    }
}
