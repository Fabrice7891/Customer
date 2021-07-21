package com.example.customer.mappers;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.entities.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    public CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    public Customer customerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO);
}
