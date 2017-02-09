package com.mokon.spring.boot.backend.model.service;

import com.mokon.spring.boot.backend.model.assembler.CustomerAssembler;
import com.mokon.spring.boot.backend.model.dto.CustomerDto;
import com.mokon.spring.boot.backend.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mokon on 09.02.2017.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<CustomerDto> findByLastName(String lastName) {
        return CustomerAssembler.toDtoCollection(repository.findByLastName(lastName));
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        return CustomerAssembler.toDto(repository.save(CustomerAssembler.toEntity(customer)));
    }

    @Override
    public Iterable<CustomerDto> save(Iterable<CustomerDto> customers) {
        return CustomerAssembler.toDtoCollection(repository.save(CustomerAssembler.toEntityCollection(customers)));
    }

    @Override
    public CustomerDto findOne(Long id) {
        return CustomerAssembler.toDto(repository.findOne(id));
    }

    @Override
    public boolean exists(Long id) {
        return repository.exists(id);
    }

    @Override
    public List<CustomerDto> findAll() {
        return CustomerAssembler.toDtoCollection(repository.findAll());
    }

    @Override
    public List<CustomerDto> findAll(Iterable<Long> ids) {
        return CustomerAssembler.toDtoCollection(repository.findAll(ids));
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void delete(CustomerDto customer) {
        repository.delete(CustomerAssembler.toEntity(customer));
    }

    @Override
    public void delete(Iterable<CustomerDto> customers) {
        repository.delete(CustomerAssembler.toEntityCollection(customers));
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
