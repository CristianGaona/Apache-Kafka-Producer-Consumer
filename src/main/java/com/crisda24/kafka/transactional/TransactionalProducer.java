package com.crisda24.kafka.transactional;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TransactionalProducer {
	public static final Logger log = LoggerFactory.getLogger(TransactionalProducer.class);
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Properties props=new Properties();
		props.put("bootstrap.servers","localhost:9092"); //Broker al broker que nos vamos a conectar
		props.put("acks","all");
		props.put("transactional.id", "crisda24-producer-id");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("linger.ms", "15");
		
		
		//Método asíncrono
		try(Producer <String, String> producer = new KafkaProducer<>(props);){
			try {
			producer.initTransactions();
			producer.beginTransaction();
			for (int i = 0; i<10000; i++) {
				producer.send(new ProducerRecord<String, String>("crisda24-topic", String.valueOf(i), "crisda24-value"));
			   /* if(i==5000) {
			    	throw new Exception("Unexpected Exception");  
			    	
			    }*/
			}
			producer.commitTransaction();
			producer.flush();
		}catch (Exception e) {
			log.error("Error", e);
			producer.abortTransaction(); 
		}
		}
		log.info("El tiempo de procesamiento es de: {} ms", (System.currentTimeMillis()-startTime));
	}
}
