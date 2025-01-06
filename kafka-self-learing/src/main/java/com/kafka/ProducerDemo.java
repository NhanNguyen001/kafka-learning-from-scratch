package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
        log.info("Hello World");

        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:19092");

//        properties.setProperty("security.protocol", "SASL_SSL");
//        properties.setProperty("sasl.mechanism", "PLAIN");
//        properties.setProperty("sasl.jaas.config.", "org.apache.kafka.common.security.plain.PlainLoginModule required username='nhannt22' password='123456'");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Create a Producer Record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_java", "Hello World");

        producer.send(producerRecord);

        // tell the producer to send all data and block until done -- synchronous
        producer.flush();

        // Flush and close the producer
        producer.close();
    }
}