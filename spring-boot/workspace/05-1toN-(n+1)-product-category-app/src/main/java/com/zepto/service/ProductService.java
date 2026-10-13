package com.zepto.service;

import org.springframework.stereotype.Service;

import com.zepto.entity.CategoryEntity;
import com.zepto.entity.ProductEntity;
import com.zepto.repository.ICategoryRepository;
import com.zepto.repository.IProductRepository;
import com.zepto.request.ProductRequest;
import com.zepto.response.ProductResponse;

@Service
public class ProductService {

	private IProductRepository productRepository;

	private ICategoryRepository categoryRepository;

	public ProductService(IProductRepository productRepository, ICategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	 public ProductResponse createProduct(ProductRequest productRequest) {

	        CategoryEntity categoryEntity = categoryRepository
	                .findById(productRequest.getCategoryId())
	                .orElseThrow(() -> new RuntimeException("Category not found"));

	        ProductEntity productEntity = new ProductEntity();

	        productEntity.setName(productRequest.getName());
	        productEntity.setDescription(productRequest.getDescription());
	        productEntity.setPrice(productRequest.getPrice());
	        productEntity.setQuantity(productRequest.getQuantity());
	        productEntity.setStatus("Active");

	        productEntity.setCategory(categoryEntity);

	        ProductEntity savedEntity = productRepository.save(productEntity);

	        ProductResponse response = new ProductResponse();

	        response.setId(savedEntity.getId());
	        response.setName(savedEntity.getName());
	        response.setDescription(savedEntity.getDescription());
	        response.setPrice(savedEntity.getPrice());
	        response.setQuantity(savedEntity.getQuantity());
	        response.setStatus(savedEntity.getStatus());
	        response.setCategoryId(savedEntity.getCategory().getId());

	        return response;
	    }

}
