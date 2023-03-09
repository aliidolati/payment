package com.example.payment.repostirories;

import com.example.payment.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomersRepository extends JpaRepository<Customer,Long> {
    Customer findByCardNumber(String cardNumber) ;
    Customer findByAccountNumber(String accountNumber) ;
}
