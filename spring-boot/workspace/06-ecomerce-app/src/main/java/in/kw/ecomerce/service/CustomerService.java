package in.kw.ecomerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kw.ecomerce.entity.CustomerEntity;
import in.kw.ecomerce.entity.OrderEntity;
import in.kw.ecomerce.repository.ICustomerRepository;
import in.kw.ecomerce.request.CustomerRequest;
import in.kw.ecomerce.response.CustomerResponse;

@Service
public class CustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	// Total queries ==> N Customers ==> N + 1
	public List<CustomerResponse> findAllCustomers() {

		System.out.println("CustomerService.findAllCustomers().....Start");

		// One query to get all customers
		// Iterable<CustomerEntity> customers = customerRepository.findAll();

		/**
		 * To resolve N+1 problem we have to write this functionality
		 */
		Iterable<CustomerEntity> customers = customerRepository.findAllCustomersWithOrders();

		List<CustomerResponse> responses = new ArrayList<>();

		for (CustomerEntity customerEntity : customers) {

			System.out.println(" ID: " + customerEntity.getId());
			System.out.println(" Name: " + customerEntity.getName());
			System.out.println(" Email: " + customerEntity.getEmail());

			// Get child records
			// Orders are already fetched using JOIN FETCH
			List<OrderEntity> orders = customerEntity.getOrders();

			System.out.println();
			System.out.println(" Total orders are : " + orders.size());

			CustomerResponse customerResponse = new CustomerResponse();

			customerResponse.setId(customerEntity.getId());
			customerResponse.setName(customerEntity.getName());
			customerResponse.setEmail(customerEntity.getEmail());

			responses.add(customerResponse);
		}

		System.out.println("CustomerService.findAllCustomers().....End");

		return responses;
	}

	public CustomerResponse createCustomer(CustomerRequest customerRequest) {

		CustomerEntity customerEntity = new CustomerEntity();

		customerEntity.setName(customerRequest.getName());

		customerEntity.setEmail(customerRequest.getEmail());

		CustomerEntity responseEntity = customerRepository.save(customerEntity);

		CustomerResponse customerResponse = new CustomerResponse();

		customerResponse.setId(responseEntity.getId());

		customerResponse.setName(responseEntity.getName());

		customerResponse.setEmail(responseEntity.getEmail());

		return customerResponse;
	}

	public CustomerResponse findCustomerById(Long id) {

		CustomerEntity responseEntity = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

		CustomerResponse customerResponse = new CustomerResponse();

		customerResponse.setId(responseEntity.getId());
		customerResponse.setName(responseEntity.getName());
		customerResponse.setEmail(responseEntity.getEmail());

		return customerResponse;
	}
}