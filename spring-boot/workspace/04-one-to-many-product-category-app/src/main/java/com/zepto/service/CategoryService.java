package com.zepto.service;

import org.springframework.stereotype.Service;

import com.zepto.entity.CategoryEntity;
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
