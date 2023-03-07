package com.example.payment.services;

import com.example.payment.Exceptions.ServiceException;
import com.example.payment.models.Customer;
import com.example.payment.models.Transaction;
import com.example.payment.repostirories.CustomersRepository;
import com.example.payment.repostirories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TransactionService  {
    @Autowired
    CustomerService customerService ;
    @Autowired
    TransactionRepository transactionRepository ;
    @Transactional(rollbackFor = ServiceException.class)
    public void resolveTransaction(Transaction transaction) throws ServiceException {
        boolean isOkWithdraw = customerService.withdraw(transaction.getSenderCardNumber(), transaction.getAmount()) ;
        if (!isOkWithdraw) {
            throw new ServiceException("your balance is not enough") ;
        }
        boolean isOkDeposit = customerService.deposit(transaction.getReceiverCardNumber(),transaction.getAmount()) ;
        if (!isOkDeposit) {
            throw new ServiceException("card number not found") ;
        }
        transactionRepository.save(transaction) ;
    }


}
