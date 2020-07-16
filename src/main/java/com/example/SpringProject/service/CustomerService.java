package com.example.SpringProject.service;

import com.example.SpringProject.dao.CustomerDao;
import com.example.SpringProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;


    public String addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }

    public Optional<Customer> getCustomerById(int id){
        return customerDao.getCustomerById(id);
    }

    public String deleteById(int id) {
        return customerDao.deleteById(id);
    }

    public String uddateCustomerById(int id, Customer updateCustomer){
        return customerDao.updateCustomer(id, updateCustomer);
    }
}
