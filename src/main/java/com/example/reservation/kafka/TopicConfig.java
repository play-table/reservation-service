package com.example.reservation.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class TopicConfig {
    public final static String STORE = "store"; //store의 정보를 넘겨받은 listener(consumer)
    public final static String RESERVATION = "reservation";

    @Bean
    public NewTopic store() {
        return new NewTopic(STORE, 1, (short) 1);
    }

    @Bean
    public NewTopic reservation() {
        return TopicBuilder
                .name(RESERVATION)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
