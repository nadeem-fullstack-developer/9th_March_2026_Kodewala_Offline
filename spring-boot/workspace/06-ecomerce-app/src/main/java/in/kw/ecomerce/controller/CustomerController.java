package in.kw.ecomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<CustomerResponse>> findAllCustomers() {

		List<CustomerResponse> response = customerService.findAllCustomers();

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable Long id) {

		CustomerResponse response = customerService.findCustomerById(id);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}