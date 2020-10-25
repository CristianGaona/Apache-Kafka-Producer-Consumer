package com.crisda24.kafka.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Crisda24Producer {

	public static void main(String[] args) {
		Properties props=new Properties();
		props.put("bootstrap.servers","localhost:9092"); //Broker al broker que nos vamos a conectar
		props.put("acks","all");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		
		try(Producer <String, String> producer = new KafkaProducer<>(props);){
			producer.send(new ProducerRecord<String, String>("crisda24-topic", "crisda24-key", "crisda24-value"));
		}
	}
	
	
}
