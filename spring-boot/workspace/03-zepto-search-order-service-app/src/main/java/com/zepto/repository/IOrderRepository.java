package com.zepto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zepto.entity.OrderEntity;

public interface IOrderRepository extends CrudRepository<OrderEntity, Long> {

	// Derived Methods
	OrderEntity findOrdersByOrderId(Long orderId);

	@Query("select o from OrderEntity o where o.paymentMethod = :type") // JPQL
//	// @Query(value = "select * from orders where payment_method='UPI' and quantity
	// < 2", nativeQuery = true) // SQL
	public List<OrderEntity> findOrdersByPaymentType(@Param("type") String paymentType);
}
