package com.qa.ims.services;
import java.util.List;

import com.qa.ims.persistence.domain.Item;
public interface CrudOrderServices {

	

	

	public interface CrudOrdersServices<T> {

	    public List<Order> readAll();
	     
	    Item create(T t);
	     
	    Item update(T t);
	 
	    void delete(Long id);

	}

}
