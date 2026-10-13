package com.zepto.response;

import lombok.Data;


@Data
public class OrderResponse {
	
	
	private Long id;
	private Long orderId;
	private Long customerId;
	private Long productId;
	private Integer quantity;
	private String paymentMethod;
	private String shippingAddress;

}
