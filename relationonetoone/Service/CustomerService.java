package com.example.relationonetoone.Service;

import com.example.relationonetoone.API.APIException;
import com.example.relationonetoone.Model.Customer;
import com.example.relationonetoone.Repositry.CustomerRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepositry customerRepositry;

    public List<Customer> getall(){
        return customerRepositry.findAll();
    }

    public void add(Customer customer){
        customerRepositry.save(customer);
    }

    public void update(Integer id,Customer customer){
        if (customerRepositry.findCustomerById(id)!=null){
            Customer c=customerRepositry.findCustomerById(id);
            c.setName(customer.getName());
            customerRepositry.save(c);
        }else throw new APIException("not found");
    }

    public void delete(Integer id){
        if (customerRepositry.findCustomerById(id)!=null){
            customerRepositry.delete(customerRepositry.findCustomerById(id));
        }
        else throw new APIException("not found");
    }
}
