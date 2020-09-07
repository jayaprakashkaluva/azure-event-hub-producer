package com.jp.eventhub.service;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.eventhub.vo.Product;

@Component
public class ProductPublisher {

	@Autowired
	private EventHubProducerClient producer;
	
	@Autowired
	private ObjectMapper mapper;
	
	public void publish() {
		EventDataBatch batch = producer.createBatch();
		for(int i=0;i<1;i++) {
			StringBuffer prodId = new StringBuffer("prod").append(Math.random()*10000);
			Product product = new Product(prodId.toString(), Math.random());
			
			try {
				String productString = mapper.writeValueAsString(product);
				EventData data = new EventData(mapper.writeValueAsString(product));
				batch.tryAdd(data);
				System.out.println(productString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

		}
		producer.send(batch);
	}
	
	@PreDestroy
	public void close() {
		producer.close();
	}
}
