package com.zepto.repository;

import org.springframework.data.repository.CrudRepository;

import com.zepto.entity.OrderEntity;

public interface IOrderRepository extends CrudRepository<OrderEntity, Long> {

}
