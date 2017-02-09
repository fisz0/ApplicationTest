package com.mokon.spring.boot.backend.model.repository;

import com.mokon.spring.boot.backend.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
