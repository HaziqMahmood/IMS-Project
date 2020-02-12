package com.qa.ims.controller;

import java.util.List;

import com.qa.ims.persistence.domain.Item;

public interface CrudItemController <T>{

    
    Item create();	
    List<Item> readAll();
     
    Item update();
     
    void delete();
}
