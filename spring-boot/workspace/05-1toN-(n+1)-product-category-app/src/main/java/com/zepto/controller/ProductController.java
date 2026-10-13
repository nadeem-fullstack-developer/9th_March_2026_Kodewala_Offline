package com.zepto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.request.ProductRequest;
import com.zepto.response.ProductResponse;
import com.zepto.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("/create")
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {

		ProductResponse response = productService.createProduct(productRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
