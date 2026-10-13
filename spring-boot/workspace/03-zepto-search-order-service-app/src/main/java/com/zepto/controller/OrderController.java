package com.zepto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.response.OrderResponse;
import com.zepto.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping("/findOrder")
	public OrderResponse searchOrderById(@RequestParam("id") Long orderId) {
		return orderService.getOrderById(orderId);

	}

	@GetMapping("/paymentMethod")
	public List<OrderResponse> getOrders(@RequestParam String paymentMethod) {

		return orderService.findOrdersByPaymentType(paymentMethod);
	}

}
