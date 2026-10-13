package com.zepto.repository;

import org.springframework.data.repository.CrudRepository;

import com.zepto.entity.CategoryEntity;


public interface ICategoryRepository extends CrudRepository<CategoryEntity, Long> {

}
