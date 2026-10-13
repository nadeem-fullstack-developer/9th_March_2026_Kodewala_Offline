package in.kw.ecomerce.repository;

import org.springframework.data.repository.CrudRepository;

import in.kw.ecomerce.entity.OrderEntity;

public interface IOrderRepository extends CrudRepository<OrderEntity, Long> {

}
