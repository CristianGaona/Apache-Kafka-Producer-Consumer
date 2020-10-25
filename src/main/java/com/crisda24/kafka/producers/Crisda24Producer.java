package com.crisda24.kafka.producers;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crisda24Producer {

	public static final Logger log = LoggerFactory.getLogger(Crisda24Producer.class);
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Properties props=new Properties();
		props.put("bootstrap.servers","localhost:9092"); //Broker al broker que nos vamos a conectar
		props.put("acks","all");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("linger.ms", "15");
		
		
		//Método síncrono
	/*	try(Producer <String, String> producer = new KafkaProducer<>(props);){
			for (int i = 0; i<1000; i++) {
				producer.send(new ProducerRecord<String, String>("crisda24-topic", String.valueOf(i), "crisda24-value")).get();
			}
			producer.flush();
			
		}catch (InterruptedException | ExecutionException e) {
			log.error("El mensaje ha sido interrumpido ", e);
		} */
		
		//Método asíncrono
		try(Producer <String, String> producer = new KafkaProducer<>(props);){
			for (int i = 0; i<1000; i++) {
				producer.send(new ProducerRecord<String, String>("crisda24-topic", String.valueOf(i), "crisda24-value"));
			}
			producer.flush();
			
		}
		// El tiempo de procesamiento es de: 1134 ms
		// El tiempo de procesamiento es de: 1037 ms
		//El tiempo de procesamiento es de: 1666 ms

		log.info("El tiempo de procesamiento es de: {} ms", (System.currentTimeMillis()-startTime));
	}
	
	
}
