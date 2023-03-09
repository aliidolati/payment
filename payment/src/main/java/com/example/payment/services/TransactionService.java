package com.example.payment.services;

import com.example.payment.Exceptions.ServiceException;
import com.example.payment.models.Customer;
import com.example.payment.models.Transaction;
import com.example.payment.repostirories.CustomersRepository;
import com.example.payment.repostirories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class TransactionService extends AbstractService<TransactionRepository ,Transaction>{
    @Autowired
    CustomerService customerService ;
    private void resolveTransaction(Customer senderCustomer,Customer receiverCustomer,Transaction transaction) throws ServiceException {
        boolean isOkWithdraw = customerService.withdraw(senderCustomer,transaction.getAmount());
        if (!isOkWithdraw) {
            throw new ServiceException("your balance is not enough") ;
        }
        boolean isOkDeposit = customerService.deposit(receiverCustomer,transaction.getAmount()) ;
        if (!isOkDeposit) {
            throw new ServiceException("receiver card number was not found") ;
        }
        transaction.setSenderCardNumber(senderCustomer.getCardNumber());
        transaction.setReceiverCardNumber(receiverCustomer.getCardNumber());
        transaction.setDate(new Date());
        transaction.setReceiverAccountNumber(receiverCustomer.getAccountNumber());
        transaction.setSenderAccountNumber(senderCustomer.getAccountNumber());

        repository.save(transaction);
    }
    @Transactional(rollbackFor = ServiceException.class)
    public void cardToCardByCardNumber(Transaction transaction) throws ServiceException {
        Customer senderCustomer = customerService.repository.findByCardNumber(transaction.getSenderCardNumber());
        Customer receiverCustomer = customerService.repository.findByCardNumber(transaction.getReceiverCardNumber());
        resolveTransaction(senderCustomer,receiverCustomer,transaction);

    }
    @Transactional(rollbackFor = ServiceException.class)
    public void cardToCardByAccountNumber(Transaction transaction)throws ServiceException{
        Customer senderCustomer = customerService.repository.findByAccountNumber(transaction.getSenderAccountNumber());
        Customer receiverCustomer = customerService.repository.findByAccountNumber(transaction.getReceiverAccountNumber());
        resolveTransaction(senderCustomer,receiverCustomer,transaction);
    }

}
