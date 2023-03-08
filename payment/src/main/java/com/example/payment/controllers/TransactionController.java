package com.example.payment.controllers;

import com.example.payment.Exceptions.ServiceException;
import com.example.payment.models.Transaction;
import com.example.payment.models.TransactionDto;
import com.example.payment.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<Transaction ,TransactionDto> {
}
