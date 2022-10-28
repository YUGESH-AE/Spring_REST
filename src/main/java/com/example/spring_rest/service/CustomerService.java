package com.example.spring_rest.service;


import com.example.spring_rest.entity.Customer;
import com.example.spring_rest.exception.NoSuchCustomer;
import com.example.spring_rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer insertCustomer(Customer customer){
        return customerRepository.saveAndFlush(customer);

    }

    public Customer updateCustomer(Long phoneNo, Customer customer) throws NoSuchCustomer {
        Optional<Customer>optionalCustomer=customerRepository.findById(phoneNo);
        if(optionalCustomer.isPresent()){
            Customer cust =optionalCustomer.get();
            cust.setName(customer.getName());
            cust.setAge(customer.getAge());
            cust.setGender(customer.getGender());
            cust.setAddress(customer.getAddress());
            cust.setPlanId(customer.getPlanId());
            return customerRepository.save(cust);
        }
        else {
            throw new NoSuchCustomer("No Such Customer Exist");
        }
    }

    public String deleteCustomer(Long phoneNo) throws NoSuchCustomer {
        Optional<Customer>optionalCustomer=customerRepository.findById(phoneNo);
        if(optionalCustomer.isPresent()){
            customerRepository.deleteById(phoneNo);
            return "Customer Deleted";
        }
        else {
            throw new NoSuchCustomer("No Such Customer Exist");
        }
    }

    public Customer getACustomer(Long phoneNo) throws NoSuchCustomer {
        Optional<Customer>optionalCustomer=customerRepository.findById(phoneNo);
        if(optionalCustomer.isPresent()){
           Customer cus=optionalCustomer.get();
           return cus;
        }
        else {
            throw new NoSuchCustomer("No Such Customer Exist");

        }
    }
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }
}
