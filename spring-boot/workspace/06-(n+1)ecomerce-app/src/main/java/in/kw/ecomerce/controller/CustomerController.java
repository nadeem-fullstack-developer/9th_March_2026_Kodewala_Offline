package in.kw.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.kw.ecomerce.request.CustomerRequest;
import in.kw.ecomerce.response.CustomerResponse;
import in.kw.ecomerce.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {

		return customerService.createCustomer(customerRequest);
	}

	@GetMapping
	public void findAllCustomers() {

		customerService.findAllCustomers();
	}
}