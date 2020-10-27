package com.crisda24.kafka.callback;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Crisda24CallbackProducer {

	public static final Logger log = LoggerFactory.getLogger(Crisda24CallbackProducer.class);
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Properties props=new Properties();
		props.put("bootstrap.servers","localhost:9092"); //Broker al broker que nos vamos a conectar
		props.put("acks","all");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("linger.ms", "15");
		
		
		//Método asíncrono
		try(Producer <String, String> producer = new KafkaProducer<>(props);){
			for (int i = 0; i<10000; i++) {
				producer.send(new ProducerRecord<String, String>("crisda24-topic", String.valueOf(i), "crisda24-value"), new Callback() {
					
					@Override
					public void onCompletion(RecordMetadata metadata, Exception exception) {
						if(exception != null) {
							log.info("There was an error {}", exception.getMessage());
						}
						log.info("Offset={}, Partition={}, Topic={}", metadata.offset(),metadata.partition(),metadata.topic());
					}
				});
			}
			producer.flush();
			
		}
		
		log.info("El tiempo de procesamiento es de: {} ms", (System.currentTimeMillis()-startTime));
	
	}
}
