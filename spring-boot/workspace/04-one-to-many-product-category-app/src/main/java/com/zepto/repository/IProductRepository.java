package com.zepto.repository;

import org.springframework.data.repository.CrudRepository;

import com.zepto.entity.ProductEntity;

public interface IProductRepository extends CrudRepository<ProductEntity, Long> {

}
