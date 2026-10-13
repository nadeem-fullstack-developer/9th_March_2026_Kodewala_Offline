package in.kw.ecomerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.kw.ecomerce.entity.CustomerEntity;

public interface ICustomerRepository extends CrudRepository<CustomerEntity, Long> {
	
	@Query("SELECT DISTINCT c FROM CustomerEntity c LEFT JOIN FETCH c.orders")
	Iterable<CustomerEntity> findAllCustomersWithOrders();

}
