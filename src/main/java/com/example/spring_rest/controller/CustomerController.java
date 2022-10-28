package com.example.spring_rest.controller;

import com.example.spring_rest.entity.Customer;
import com.example.spring_rest.exception.NoSuchCustomer;
import com.example.spring_rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,path = "/insert")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
        Customer customer1=customerService.insertCustomer(customer);
        return new ResponseEntity<>(customer1,HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/getall")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer>customerList=customerService.getAllCustomer();
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/")
    public ResponseEntity<String> deleteCustomer(@RequestParam("no")Long phoneNo) throws NoSuchCustomer {
        String response= customerService.deleteCustomer(phoneNo);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE
    ,path = "/update")
    public ResponseEntity<Customer> updateCustomer(@RequestParam("no")Long phoneNo, @RequestBody Customer customer) throws NoSuchCustomer {
        Customer cus=customerService.updateCustomer(phoneNo, customer);
        return new ResponseEntity<>(cus,HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/geta/{no}")
    public ResponseEntity<Customer> getACustomer(@PathVariable("no") Long phoneNo) throws NoSuchCustomer {
        Customer customer=customerService.getACustomer(phoneNo);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }


}
