package com.qa.ims.services;
import java.util.List;
import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;

import com.qa.ims.persistence.domain.Order;


public class OrderServices implements CrudServices<Order> {
	
	
		private Dao<Order> ordersDao;
		public OrderServices(Dao<Order> ordersDao) {
			this.ordersDao = ordersDao;
		}
		public List<Order> readAll() {
			return ordersDao.readAll();
		}
		public Order create(Order orders) {
			return ordersDao.create(orders);
		}
		public Order update(Order orders) {
			return ordersDao.update(orders);
		}
		public void delete(Long orders_id) {
			ordersDao.delete(orders_id);
		}
	}


