package com.jp.eventhub.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
	private String id;

	public Product(String id, double price) {
		super();
		this.id = id;
		this.price = price;
	}

	private double price;
}
