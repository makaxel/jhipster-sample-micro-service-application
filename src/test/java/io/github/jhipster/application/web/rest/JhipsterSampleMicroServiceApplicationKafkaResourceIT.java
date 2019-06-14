package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleMicroServiceApplicationApp;
import io.github.jhipster.application.service.JhipsterSampleMicroServiceApplicationKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = JhipsterSampleMicroServiceApplicationApp.class)
public class JhipsterSampleMicroServiceApplicationKafkaResourceIT {

    @Autowired
    private JhipsterSampleMicroServiceApplicationKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        JhipsterSampleMicroServiceApplicationKafkaResource kafkaResource = new JhipsterSampleMicroServiceApplicationKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/jhipster-sample-micro-service-application-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
