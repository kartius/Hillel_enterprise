package org.example.lesson19_kafka_producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class Lesson19KafkaProducerApplication {

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(Lesson19KafkaProducerApplication.class, args);

    //step 1
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // step 2
    try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {

      //step 3
      ProducerRecord<String, String> producerRecord = new ProducerRecord<>("first_topic", "1","test producer");

      //step 4
      for (int i = 0; i < 10; i++) {
        producer.send(producerRecord, (recordMetadata, e) -> {
          if (e == null) {
            System.out.println("Success sending");
            System.out.println("Topic - " + recordMetadata.topic());
            System.out.println("Partition - " + recordMetadata.partition());
            System.out.println("Offset - " + recordMetadata.offset());
            System.out.println("Timestamp - " + recordMetadata.timestamp());
          } else {
            throw new RuntimeException("ALARM!!", e);
          }
        });
        Thread.sleep(1000);
        producer.flush();
      }

    }
  }

}
