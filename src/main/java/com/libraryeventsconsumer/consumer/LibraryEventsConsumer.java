package com.libraryeventsconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryeventsconsumer.domain.LibraryEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventsConsumer {

    ObjectMapper objectMapper = new ObjectMapper();

        @KafkaListener(topics = "library-events")
        public void onMessage(String data) throws JsonProcessingException {
            log.info("ConsumerRecords: {}",data);
            //Json string to Object
            LibraryEvent libraryEvent=objectMapper.readValue(data,LibraryEvent.class);

        }
}
