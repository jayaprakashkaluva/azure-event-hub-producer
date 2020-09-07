package com.jp.eventhub.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jp.eventhub.service.ProductPublisher;

@Component
public class ProductScheduler {

	@Autowired
	private ProductPublisher publisher;
	
	@Scheduled(fixedRate = 3000)
	public void publias() {
		publisher.publish();
	}
}
