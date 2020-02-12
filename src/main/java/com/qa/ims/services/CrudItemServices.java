package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;

public interface CrudItemServices<T> {

    public List<Item> readAll();
     
    Item create(T t);
     
    Item update(T t);
 
    void delete(Long id);

}
