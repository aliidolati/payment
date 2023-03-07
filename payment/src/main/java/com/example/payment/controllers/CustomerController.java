package com.example.payment.controllers;

import com.example.payment.Exceptions.ServiceException;
import com.example.payment.models.Customer;
import com.example.payment.models.CustomerDto;
import com.example.payment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractController<Customer,CustomerDto> {

}
