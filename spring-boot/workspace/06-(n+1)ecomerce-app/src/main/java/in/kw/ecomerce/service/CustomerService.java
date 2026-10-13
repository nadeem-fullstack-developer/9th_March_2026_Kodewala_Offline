package in.kw.ecomerce.service;

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
	public void findAllCustomers() {

		System.out.println("CustomerService.findAllCustomers().....Start");

		// One query to get all customers
		Iterable<CustomerEntity> customers = customerRepository.findAll();

		for (CustomerEntity customerEntity : customers) {

			System.out.println(" ID: " + customerEntity.getId());

			System.out.println(" Name: " + customerEntity.getName());

			System.out.println(" Email: " + customerEntity.getEmail());

			// Get child records
			// Because orders are LAZY, this can fire one query per customer
			List<OrderEntity> orders = customerEntity.getOrders();

			System.out.println();

			System.out.println(" Total orders are : " + orders.size());
		}

		System.out.println("CustomerService.findAllCustomers().....End");
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
}