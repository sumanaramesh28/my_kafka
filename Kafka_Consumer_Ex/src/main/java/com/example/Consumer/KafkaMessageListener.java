package com.example.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

   Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

   @KafkaListener(topics = "topic_check", groupId = "Sum_group")
   public void consume1(String message){
       log.info("Consumer 1 consume the message {} " , message);
   }

    @KafkaListener(topics = "topic_check", groupId = "Sum_group")
    public void consume2(String message){
        log.info("Consumer 2 consume the message {} " , message);
    }

    @KafkaListener(topics = "topic_check", groupId = "Sum_group")
    public void consume3(String message){
        log.info("Consumer 3 consume the message {} " , message);
    }

    @KafkaListener(topics = "topic_check", groupId = "Sum_group")
    public void consume4(String message){
        log.info("Consumer 4 consume the message {} " , message);
    }



}
