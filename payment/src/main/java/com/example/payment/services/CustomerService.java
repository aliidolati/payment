package com.example.payment.services;

import com.example.payment.Exceptions.ServiceException;
import com.example.payment.models.Customer;
import com.example.payment.repostirories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<CustomersRepository,Customer> {
    @Autowired
    CustomersRepository customersRepository ; //ino az ostad bepors : repository to abstract

    public boolean withdraw(String cardNumber,Long amount){
        Customer customer = customersRepository.findByCardNumber(cardNumber) ;
        if (customer.getBalance() == null) {
            return false ;

        }
        if (customer.getBalance() >= amount) {
            customer.setBalance(customer.getBalance() - amount);
            return true ;
        }
        return false ;
    }
    public boolean deposit(String cardNumber , Long amount){
        Customer customer = customersRepository.findByCardNumber(cardNumber) ;
        if(customer != null){
            customer.setBalance(customer.getBalance() + amount);
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
