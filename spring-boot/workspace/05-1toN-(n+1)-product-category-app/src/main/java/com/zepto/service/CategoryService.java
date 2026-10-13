package com.zepto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zepto.entity.CategoryEntity;
import com.zepto.entity.ProductEntity;
import com.zepto.repository.ICategoryRepository;
import com.zepto.request.CategoryRequest;
import com.zepto.response.CategoryResponse;

@Service
public class CategoryService {

	private ICategoryRepository categoryRepository;

	public CategoryService(ICategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	// total for queries ==> N Categories ====> N+1
	public void findAllCategories() {

		System.out.println("CategoryService.findAllCategories().....Start");

		// fired one query to get all record
		Iterable<CategoryEntity> categories = categoryRepository.findAll();

		for (CategoryEntity categoryEntity : categories) {

			System.out.println(" ID: " + categoryEntity.getId());
			System.out.println(" Name: " + categoryEntity.getName());
			System.out.println(" Description: " + categoryEntity.getDescription());
			System.out.println(" Status: " + categoryEntity.getStatus());

			// please get the child as well, one query per category
			List<ProductEntity> products = categoryEntity.getProducts();

			System.out.println();

			System.out.println(" Total products are : " + products.size());

		}
		System.out.println("CategoryService.findAllCategories().....End");

	}

	public CategoryResponse createCategory(CategoryRequest categoryRequest) {

		CategoryEntity categoryEntity = new CategoryEntity();

		categoryEntity.setName(categoryRequest.getName());
		categoryEntity.setDescription(categoryRequest.getDescription());
		categoryEntity.setStatus("Active");

		CategoryEntity responseEntity = categoryRepository.save(categoryEntity);

		CategoryResponse response = new CategoryResponse();

		response.setId(responseEntity.getId());
		response.setName(responseEntity.getName());
		response.setDescription(responseEntity.getDescription());
		response.setStatus(responseEntity.getStatus());

		return response;

	}
}
