package com.example.customer.service;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.exception.RessourseNotFounfException;

import java.util.List;

public interface CustomerService {

    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    public List<CustomerResponseDTO> getAllCustomer();
    public CustomerResponseDTO getCustomerById(String customeId) throws RessourseNotFounfException;
    public CustomerResponseDTO update(String IdCustomer ,CustomerRequestDTO customerRequestDTO) throws RessourseNotFounfException;
    public CustomerResponseDTO deleteCustomer(String idCustomer) throws RessourseNotFounfException;

}
