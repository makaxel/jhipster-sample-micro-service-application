package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.JhipsterSampleMicroServiceApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-sample-micro-service-application-kafka")
public class JhipsterSampleMicroServiceApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterSampleMicroServiceApplicationKafkaResource.class);

    private JhipsterSampleMicroServiceApplicationKafkaProducer kafkaProducer;

    public JhipsterSampleMicroServiceApplicationKafkaResource(JhipsterSampleMicroServiceApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
