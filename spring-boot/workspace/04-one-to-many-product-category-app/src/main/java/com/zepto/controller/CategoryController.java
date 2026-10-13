package com.zepto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.request.CategoryRequest;
import com.zepto.response.CategoryResponse;
import com.zepto.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@PostMapping("/create")
	public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {

		CategoryResponse response = categoryService.createCategory(categoryRequest);

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
