package com.example.customer.web;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class CustomerRestAPI {

    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping(path = "/customers")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/customers/{idcustomer}")
    public CustomerResponseDTO getCustomerById(@PathVariable String idcustomer){
        return customerService.getCustomerById(idcustomer);
    }

    @PutMapping(path = "/customers")
    public CustomerResponseDTO updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.update(customerRequestDTO);
    }
}
