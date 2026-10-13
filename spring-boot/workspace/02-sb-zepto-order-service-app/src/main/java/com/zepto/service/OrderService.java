package com.zepto.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.zepto.entity.OrderEntity;
import com.zepto.repository.IOrderRepository;
import com.zepto.request.OrderRequest;
import com.zepto.response.OrderResponse;

@Service
public class OrderService {

	private IOrderRepository orderRepository;

	public OrderService(IOrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	public OrderResponse aceeptOrder(OrderRequest orderRequest) {

		System.out.println("OrderService.aceeptOrder() :::: START");

		OrderEntity entity = new OrderEntity();

		entity.setCustomerId(orderRequest.getCustomerId());
		entity.setPaymentMethod(orderRequest.getPaymentMethod());
		entity.setProductId(orderRequest.getProductId());
		entity.setQuantity(orderRequest.getQuantity());
		entity.setShippingAddress(orderRequest.getShippingAddress());

		// Biz Logic
		entity.setOrderId(generateOrderID());

		OrderEntity responseEntity = orderRepository.save(entity);

		OrderResponse orderResponse = new OrderResponse();

		orderResponse.setOrderId(responseEntity.getOrderId());
		orderResponse.setCustomerId(responseEntity.getCustomerId());
		orderResponse.setTotalAmount(2312L);
		orderResponse.setPaymentStatus("SUCCESS");
		orderResponse.setOrderStatus("PLACED");
		
		System.out.println("OrderService.acceptOrder() ::::: END");

		return orderResponse;
	}

	private Long generateOrderID() {

		Random random = new Random();

		Long id = 10000 + random.nextLong(90000);

		return id;
	}
}
