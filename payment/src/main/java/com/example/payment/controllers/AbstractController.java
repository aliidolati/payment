package com.example.payment.controllers;

import com.example.payment.Exceptions.ServiceException;
import com.example.payment.convertors.BaseConvertor;
import com.example.payment.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class AbstractController<E,D> {
    @Autowired
    protected AbstractService<? extends JpaRepository<E,Long>,E> service ;
    @Autowired
    protected BaseConvertor<D, E> converter;
    @PostMapping("/")
    @Transactional
    public void add(@RequestBody D d) throws ServiceException {
        service.add(converter.convertDto(d));
    }
    public void update(@RequestBody D d){
        service.update(converter.convertDto(d));
    }
    @GetMapping("/{id}")
    public void findById(@PathVariable("id") Long id) throws ServiceException {
        service.findById(id) ;
    }

 }
