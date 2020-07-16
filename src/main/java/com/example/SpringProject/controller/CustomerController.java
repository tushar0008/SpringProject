package com.example.SpringProject.controller;

import com.example.SpringProject.model.Customer;
import com.example.SpringProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("app/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @RequestMapping(path = "/get_all", method = RequestMethod.GET)
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(path = "/get_by_id/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomerById(@PathVariable("id") int id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int id){
        return customerService.deleteById(id);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public String updateCustomer(@PathVariable("id") int id, @RequestBody Customer updateCustomer){
        return customerService.uddateCustomerById(id, updateCustomer);
    }
}
