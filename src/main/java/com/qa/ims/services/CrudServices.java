package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.domain.Customer;

public interface CrudServices<T> {

    public List<Customer> readAll();
     
    Customer create(T t);
     
    Customer update(T t);
 
    void delete(Long id);

}
