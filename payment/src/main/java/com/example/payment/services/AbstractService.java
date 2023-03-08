package com.example.payment.services;

import com.example.payment.Exceptions.ServiceException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public  class AbstractService<R extends JpaRepository<E,Long>,E> {
    @Autowired
    protected R repository ;


    public void add(E e) throws ServiceException{
        repository.save(e) ;
    }
    public void update(E e){
        repository.save(e) ;
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Optional<E> findById(Long id) throws ServiceException {
        return repository.findById(id) ;
    }
    public List<E> getAll(){
        return repository.findAll() ;
    }
}
