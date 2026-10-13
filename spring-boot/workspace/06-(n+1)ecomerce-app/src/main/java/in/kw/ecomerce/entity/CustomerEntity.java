package in.kw.ecomerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<OrderEntity> orders = new ArrayList<>();

	public void addOrder(OrderEntity order) {
		orders.add(order);
		order.setCustomer(this);
	}

	public void removeOrder(OrderEntity order) {
		orders.remove(order);
		order.setCustomer(null);
	}

	public CustomerEntity() {
	}

	public CustomerEntity(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
