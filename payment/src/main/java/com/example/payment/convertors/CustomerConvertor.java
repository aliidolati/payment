package com.example.payment.convertors;

import com.example.payment.models.Customer;
import com.example.payment.models.CustomerDto;
import com.example.payment.models.Transaction;
import com.example.payment.models.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerConvertor implements BaseConvertor<CustomerDto, Customer> {

    @Override
    public Customer convertDto(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setAge(customerDto.getAge());
        customer.setBalance(customerDto.getBalance());
        customer.setGender(customerDto.getGender());
        customer.setCardNumber(customerDto.getCardNumber());
        customer.setVersion(customerDto.getVersion());
        return customer;

    }

    @Override
    public CustomerDto convertEntity(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setAge(customer.getAge());
        customerDto.setBalance(customer.getBalance());
        customerDto.setGender(customer.getGender());
        customerDto.setCardNumber(customer.getCardNumber());
        customerDto.setVersion(customer.getVersion());
        return customerDto;
    }
}
