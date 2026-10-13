package com.zepto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.request.OrderRequest;
import com.zepto.response.OrderResponse;
import com.zepto.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {

		this.orderService = orderService;
	}

	@PostMapping("/place")
	public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {

		System.out.println("OrderController.placeOrder()::::::::::START");

		OrderResponse orderResponse = orderService.aceeptOrder(orderRequest);

		System.out.println("OrderController.placeOrder()::::::::: END");

		return orderResponse;

	}
}
