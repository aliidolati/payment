package com.example.payment.services;

import com.example.payment.Exceptions.ServiceException;
import com.example.payment.models.Customer;
import com.example.payment.models.Transaction;
import com.example.payment.repostirories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<CustomersRepository,Customer> {

    public boolean withdraw(Customer customer,Long amount){
        if(customer != null && customer.getBalance() >= amount){
            customer.setBalance(customer.getBalance()-amount);
            return true ;
        }else {

            return false ;
        }
    }
    public boolean deposit(Customer customer , Long amount){
        if (customer != null) {
            customer.setBalance(customer.getBalance()+amount);
            return true ;
        }else return false ;
    }

    @Override
    public void add(Customer customer) throws ServiceException {
        try {
            super.add(customer);
        }catch (ServiceException sx){
            throw  new ServiceException("could not add the customer") ;
        }

    }

}
