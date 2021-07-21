package com.example.customer.service.impl;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.entities.Customer;
import com.example.customer.exception.RessourseNotFounfException;
import com.example.customer.mappers.CustomerMapper;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper1;




    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper1) {
        this.customerRepository = customerRepository;

        this.customerMapper1 = customerMapper1;
    }

    @Override
    public CustomerResponseDTO save(@Valid CustomerRequestDTO customerRequestDTO) {

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
    public CustomerResponseDTO getCustomerById(String customeId) throws RessourseNotFounfException {

        if(!customerRepository.findById(customeId).isPresent()) throw new RessourseNotFounfException("Customer with Id :"+ customeId+ " not found");
        return customerMapper1.customerToCustomerResponseDTO(customerRepository.findById(customeId).get());
    }

    @Override
    public CustomerResponseDTO update(String IdCustomer, CustomerRequestDTO customerRequestDTO) throws RessourseNotFounfException {
        if(!customerRepository.findById(IdCustomer).isPresent()) throw new RessourseNotFounfException("Customer with Id :"+ IdCustomer +" not found");
        Customer customer= customerRepository.findById(IdCustomer).get();
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customerRequestDTO.getEmail());
        customerRepository.save(customer);
        return customerMapper1.customerToCustomerResponseDTO(customer);
    }


    @Override
    public CustomerResponseDTO deleteCustomer(String idCustomer) throws RessourseNotFounfException {
        if(!customerRepository.findById(idCustomer).isPresent()) throw new RessourseNotFounfException("Customer with Id :"+ idCustomer +" not found");
        Customer customer=customerRepository.findById(idCustomer).get();
        customerRepository.delete(customerRepository.findById(idCustomer).get());
        return customerMapper1.customerToCustomerResponseDTO(customer);
    }
}
