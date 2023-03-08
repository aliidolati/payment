package com.example.payment.convertors;

import com.example.payment.models.Transaction;
import com.example.payment.models.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public class TransactionConvertor implements BaseConvertor<TransactionDto, Transaction>{
    @Override
    public Transaction convertDto(TransactionDto transactionDto) {
        Transaction transaction =  new Transaction( );
        transaction.setId(transactionDto.getId()) ;
        transaction.setDate(transactionDto.getDate());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setReceiverCardNumber(transactionDto.getReceiverCardNumber());
        transaction.setSenderCardNumber(transactionDto.getSenderCardNumber());

        return transaction ;
    }

    @Override
    public TransactionDto convertEntity(Transaction transaction) {
        TransactionDto transactionDto =  new TransactionDto( );
        transactionDto.setId(transaction.getId()) ;
//        transactionDto.setLastUpdateTimestamp(transaction.getLastUpdateTimeStamp());
//        transactionDto.setInsertTimestamp(transaction.getInsertTimeStamp()); ;
        transactionDto.setDate(transaction.getDate());
        transactionDto.setAmount(transaction.getAmount());
        //transactionDto.setVersion(transaction.getVersion());
        transactionDto.setReceiverCardNumber(transaction.getReceiverCardNumber());
        transactionDto.setSenderCardNumber(transaction.getSenderCardNumber());

        return transactionDto ;
    }
}
