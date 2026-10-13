package in.kw.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kw.ecomerce.entity.CustomerEntity;
import in.kw.ecomerce.entity.OrderEntity;
import in.kw.ecomerce.repository.ICustomerRepository;
import in.kw.ecomerce.repository.IOrderRepository;
import in.kw.ecomerce.request.OrderRequest;
import in.kw.ecomerce.response.OrderResponse;

@Service
public class OrderService {

	@Autowired
	IOrderRepository orderRepository;

	@Autowired
	ICustomerRepository customerRepository;

	public OrderResponse createOrder(OrderRequest orderRequest) {

		CustomerEntity customerEntity = customerRepository.findById(orderRequest.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + orderRequest.getCustomerId()));

		OrderEntity orderEntity = new OrderEntity();

		orderEntity.setOrderNumber(orderRequest.getOrderNumber());
		orderEntity.setOrderDate(orderRequest.getOrderDate());
		orderEntity.setTotalAmount(orderRequest.getTotalAmount());
		orderEntity.setStatus(orderRequest.getStatus());

		orderEntity.setCustomer(customerEntity);

		OrderEntity responseEntity = orderRepository.save(orderEntity);

		OrderResponse orderResponse = new OrderResponse();

		orderResponse.setId(responseEntity.getId());
		orderResponse.setOrderNumber(responseEntity.getOrderNumber());
		orderResponse.setOrderDate(responseEntity.getOrderDate());
		orderResponse.setTotalAmount(responseEntity.getTotalAmount());
		orderResponse.setStatus(responseEntity.getStatus());
		orderResponse.setCustomerId(customerEntity.getId());

		return orderResponse;
	}
}