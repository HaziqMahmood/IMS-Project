package com.qa.ims.services;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;
@RunWith(MockitoJUnitRunner.class)

public class ItemServicesTest {
	
	
	
		@Mock
		private Dao<Item> itemsDao;
		@InjectMocks
		private ItemServices itemsServices;
		@Test
		public void itemsServicesCreate() {
			Item item = new Item("Water bottle", 5.49);
			itemsServices.create(item);
			Mockito.verify(itemsDao, Mockito.times(1)).create(item);
		}
		@Test
		public void itemsServicesRead() {
			itemsServices.readAll();
			Mockito.verify(itemsDao, Mockito.times(1)).readAll();
		}
		@Test
		public void itemsServicesUpdate() {
			Item item = new Item("mobile", 45.99);
			itemsServices.update(item);
			Mockito.verify(itemsDao, Mockito.times(1)).update(item);
		}
		@Test
		public void itemsServicesDelete() {
			itemsServices.delete(1L);;
			Mockito.verify(itemsDao, Mockito.times(1)).delete(1L);
		}
	}


