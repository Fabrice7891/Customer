package com.example.customer.service.impl;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.entities.Customer;
import com.example.customer.mappers.CustomerMapper;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper1;




    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper1) {
        this.customerRepository = customerRepository;

        this.customerMapper1 = customerMapper1;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {

        // Mapper customerRequestDTO en customer
        Customer customer= customerMapper1.customerRequestDTOCustomer(customerRequestDTO);

        //Specifie l ID de facon aleatoire
        customer.setId(UUID.randomUUID().toString());

        //Save
        //customerRepository.save(customer);

        //Mapper customer en customerRequestDTO
        return customerMapper1.customerToCustomerResponseDTO(customerRepository.save(customer));

    }

    @Override
    public List<CustomerResponseDTO> getAllCustomer() {
       // List<Customer> customers= customerRepository.findAll();

        return customerRepository.findAll()
                .stream()
                    .map(cust->customerMapper1.customerToCustomerResponseDTO(cust))
                    .collect(Collectors.toList());

    }

    @Override
    public CustomerResponseDTO getCustomerById(String customeId) {

        //Customer customer= customerRepository.findById(customeId).get();

        return customerMapper1.customerToCustomerResponseDTO(customerRepository.findById(customeId).get());
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
       // Customer customer= customerMapper.customerRequestDTOCustomer(customerRequestDTO);

        return customerMapper1.customerToCustomerResponseDTO(customerRepository
                .save(customerMapper1.customerRequestDTOCustomer(customerRequestDTO)));
    }
}
