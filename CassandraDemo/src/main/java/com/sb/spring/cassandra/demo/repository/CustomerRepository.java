package com.sb.spring.cassandra.demo.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sb.spring.cassandra.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	@Query(value = "SELECT * FROM customer WHERE firstname=?0 ALLOW FILTERING")
	public List<Customer> findByFirstname(String firstname);

	@Query("SELECT * FROM customer WHERE age > ?0 ALLOW FILTERING")
	public List<Customer> findCustomerHasAgeGreaterThan(int age);
}