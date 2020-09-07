package com.jp.eventhub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;

@Configuration
public class EventHubConfig {
	
	@Value("${eventhub.connection}")
	private String connectionString;
	@Value("${eventhub.name}")
	private String eventHubName;

	@Bean
	public EventHubProducerClient producer() {
		return new EventHubClientBuilder()
	            .connectionString(connectionString, eventHubName)
	            .buildProducerClient();
	}
}
