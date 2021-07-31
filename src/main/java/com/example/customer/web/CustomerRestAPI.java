package com.example.customer.web;

import com.example.customer.dto.CustomerRequestDTO;
import com.example.customer.dto.CustomerResponseDTO;
import com.example.customer.exception.NullException;
import com.example.customer.exception.RessourseNotFounfException;
import com.example.customer.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerRestAPI {

    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/")
    public List<CustomerResponseDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    /*@PostMapping(path = "/customers")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }*/
    /*@GetMapping(path = "/customers/{idcustomer}")
    public CustomerResponseDTO getCustomerById(@PathVariable String idcustomer) throws RessourseNotFounfException {
        return customerService.getCustomerById(idcustomer);
    }*/

    @PutMapping(path = "/{id}")
    public CustomerResponseDTO updateCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO, @PathVariable String id) throws RessourseNotFounfException {
        return customerService.update(id,customerRequestDTO);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create a Customer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) throws NullException {
        return new ResponseEntity<>(customerService.save(customerRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCatById(@PathVariable("id") String id) throws RessourseNotFounfException {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> deleteCustomer(@PathVariable("id") String id) throws RessourseNotFounfException {
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }


}
