package com.crisda24.kafka.multithread;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crisda24ThreadConsumer extends Thread {
	private final KafkaConsumer<String, String> consumer;
	private final AtomicBoolean closed = new AtomicBoolean(false);
	private static final Logger log = LoggerFactory.getLogger(Crisda24ThreadConsumer.class);
	
	public Crisda24ThreadConsumer(KafkaConsumer<String, String> consumer) {
		this.consumer = consumer;
	}

	@Override
	public void run() {
		
	
			try {
				consumer.subscribe(Arrays.asList("crisda24-topic"));
				while(!closed.get()) {
					ConsumerRecords<String, String> consumerRecords=consumer.poll(Duration.ofMillis(100));
					for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
						log.debug("Offset = {}, Partition {}, Key={}, Value{} ", consumerRecord.offset(), consumerRecord.partition(), consumerRecord.key(), consumerRecord.value());
					    if((Integer.parseInt(consumerRecord.key())% 100000)== 0 ) {
					    	log.info("Offset = {}, Partition {}, Key={}, Value{} ", consumerRecord.offset(), consumerRecord.partition(), consumerRecord.key(), consumerRecord.value());
					    }
					}
				}
				
			} catch (WakeupException e) {
				if(!closed.get()) {
					throw e;
				}
			}finally {
				consumer.close();
			}
		}
	

	public void shutdown() {
		closed.set(true);
		consumer.wakeup();
	}
}
