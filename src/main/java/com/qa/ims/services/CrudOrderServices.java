package com.qa.ims.services;
import java.util.List;


import com.qa.ims.persistence.domain.Order;
public interface CrudOrderServices {

	

	

	public interface CrudOrdersServices<T> {

	    public List<Order> readAll();
	     
	    Order create(T t);
	     
	    Order update(T t);
	 
	    void delete(Long id);

	}

}
