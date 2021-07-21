package com.example.customer.service;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    public List<CustomerResponseDTO> getAllCustomer();
    public CustomerResponseDTO getCustomerById(String customeId);
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);

}
