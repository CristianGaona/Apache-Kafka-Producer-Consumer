package com.crisda24.kafka.consumers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crisda24Consumer {

	private static final Logger log = LoggerFactory.getLogger(Crisda24Consumer.class);
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers","localhost:9092");
		props.setProperty("group.id","devs4j-group");
		props.setProperty("enable.auto.commit","true");
		props.setProperty("auto.commit.interval.ms","1000");
		props.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		try(KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)){
			consumer.subscribe(Arrays.asList("crisda24-topic"));
			/*TopicPartition topicPartition = new TopicPartition("crisda24-topic", 1);
			consumer.assign(Arrays.asList(topicPartition));
			consumer.seek(topicPartition, 50);*/
			while(true) {
				ConsumerRecords<String, String> consumerRecords=consumer.poll(Duration.ofMillis(100));
				for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
					log.info("Offset = {}, Partition {}, Key={}, Value{} ", consumerRecord.offset(), consumerRecord.partition(), consumerRecord.key(), consumerRecord.value());
				    consumer.commitSync();
				}
			}
			
		}
	}
}
