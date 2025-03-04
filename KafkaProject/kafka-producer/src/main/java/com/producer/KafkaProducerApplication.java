package com.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class);
    }

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;
    @Override
    public void run(String... args) throws Exception {
     wikimediaChangesProducer.sendMessage();
    }
}