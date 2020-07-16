package com.example.SpringProject.dao;

import com.example.SpringProject.model.Customer;
import com.example.SpringProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;


    public String addCustomer(Customer customer) {
        customerRepository.insert(customer);
        return "Customer inserted with id " + customer.getId();
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int id){
        return customerRepository.findById(id);
    }

    public String deleteById(int id) {
        if(getCustomerById(id).isPresent()){
            customerRepository.deleteById(id);
            return "Customer with id " + id + " deleted";
        } else{
            return "No Such Customer exist";
        }
    }

    public String updateCustomer(int id, Customer updateCustomer){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customer.get().setName(updateCustomer.getName());
            customer.get().setEmail(updateCustomer.getEmail());
            customer.get().setPhoneNumber(updateCustomer.getPhoneNumber());
            customerRepository.save(customer.get());
            return "Customer with id " + id + " updated";
        }
        return "No Such Customer Exist";
    }
}
