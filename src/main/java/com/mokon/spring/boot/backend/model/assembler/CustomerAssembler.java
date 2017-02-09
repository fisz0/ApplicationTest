package com.mokon.spring.boot.backend.model.assembler;

import com.mokon.spring.boot.backend.model.dto.CustomerDto;
import com.mokon.spring.boot.backend.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokon on 09.02.2017.
 */
public class CustomerAssembler {

    public static CustomerDto toDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        return dto;
    }

    public static Customer toEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setLastName(dto.getLastName());
        customer.setFirstName(dto.getFirstName());
        return customer;
    }

    public static List<CustomerDto> toDtoCollection(Iterable<Customer> customers) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        customers.forEach(e -> customerDtos.add(toDto(e)));
        return customerDtos;
    }

    public static List<Customer> toEntityCollection(Iterable<CustomerDto> customerDtos) {
        List<Customer> customers = new ArrayList<>();
        customerDtos.forEach(dto -> customers.add(toEntity(dto)));
        return customers;
    }
}
