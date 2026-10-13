package in.kw.ecomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.kw.ecomerce.request.OrderRequest;
import in.kw.ecomerce.response.OrderResponse;
import in.kw.ecomerce.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping("/create")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {

		OrderResponse response = orderService.createOrder(orderRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<OrderResponse>> findOrdersByCustomerId(
			@PathVariable Long customerId) {

		List<OrderResponse> response =
				orderService.findOrdersByCustomerId(customerId);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}