package com.jp.eventhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.eventhub.service.ProductPublisher;

@RestController
public class ProductsController {

	@Autowired
	private ProductPublisher publisher;
	
	@PostMapping("/products/launch")
	public void launchNewProducts() {
		publisher.publish();
	}
}
