package com.mokon.spring.boot.backend.model.service;

import com.mokon.spring.boot.backend.model.dto.CustomerDto;

import java.util.List;

/**
 * Created by mokon on 09.02.2017.
 */
public interface CustomerService {

    List<CustomerDto> findByLastName(String lastName);

    CustomerDto save(CustomerDto customer);

    Iterable<CustomerDto> save(Iterable<CustomerDto> customers);

    CustomerDto findOne(Long id);

    boolean exists(Long id);

    Iterable<CustomerDto> findAll();

    Iterable<CustomerDto> findAll(Iterable<Long> ids);

    long count();

    void delete(Long id);

    void delete(CustomerDto customer);

    void delete(Iterable<CustomerDto> customers);

    void deleteAll();
}
