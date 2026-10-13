package com.zepto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zepto.entity.OrderEntity;
import com.zepto.repository.IOrderRepository;
import com.zepto.response.OrderResponse;

@Service
public class OrderService {

	IOrderRepository orderRepository;

	public OrderService(IOrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	/*
	 * public OrderResponse getOrderById(Long orderId) {
	 * 
	 * System.out.println("OrderService.getOrderById()......start");
	 * 
	 * OrderEntity orderEntity = orderRepository.findById(orderId) .orElseThrow(()
	 * -> new RuntimeException("Order not found with id: " + orderId));
	 * 
	 * OrderResponse orderResponse = new OrderResponse();
	 * 
	 * orderResponse.setId(orderEntity.getId());
	 * orderResponse.setOrderId(orderEntity.getOrderId());
	 * orderResponse.setCustomerId(orderEntity.getCustomerId());
	 * orderResponse.setProductId(orderEntity.getProductId());
	 * orderResponse.setQuantity(orderEntity.getQuantity());
	 * orderResponse.setPaymentMethod(orderEntity.getPaymentMethod());
	 * orderResponse.setShippingAddress(orderEntity.getShippingAddress());
	 * 
	 * System.out.println("OrderService.getOrderById().......end");
	 * 
	 * return orderResponse; }
	 */

	public OrderResponse getOrderById(Long orderId) {

		System.out.println("OrderService.getOrderById()......start");

		OrderEntity orderEntity = orderRepository.findOrdersByOrderId(orderId);

		OrderResponse orderResponse = new OrderResponse();

		orderResponse.setId(orderEntity.getId());
		orderResponse.setOrderId(orderEntity.getOrderId());
		orderResponse.setCustomerId(orderEntity.getCustomerId());
		orderResponse.setProductId(orderEntity.getProductId());
		orderResponse.setQuantity(orderEntity.getQuantity());
		orderResponse.setPaymentMethod(orderEntity.getPaymentMethod());
		orderResponse.setShippingAddress(orderEntity.getShippingAddress());

		System.out.println("OrderService.getOrderById().......end");

		return orderResponse;
	}

	public List<OrderResponse> findOrdersByPaymentType(String paymentType) {

		List<OrderEntity> orders = orderRepository.findOrdersByPaymentType(paymentType);

		List<OrderResponse> responseList = new ArrayList<>();

		for (OrderEntity order : orders) {

			OrderResponse response = new OrderResponse();

			response.setId(order.getId());
			response.setOrderId(order.getOrderId());
			response.setCustomerId(order.getCustomerId());
			response.setProductId(order.getProductId());
			response.setQuantity(order.getQuantity());
			response.setPaymentMethod(order.getPaymentMethod());
			response.setShippingAddress(order.getShippingAddress());

			responseList.add(response);
		}

		return responseList;
	}
}
