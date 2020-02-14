package com.qa.ims.controller;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;
@RunWith(MockitoJUnitRunner.class)

public class ItemControllerTest {
	
	
	
		/**
		 *  The thing I want to fake functionality for
		 */
		@Mock
		private ItemServices itemServices;
		/**
		 * Spy is used because i want to mock some methods inside the item I'm testing
		 * InjectMocks uses dependency injection to insert the mock into the item controller
		 */
		@Spy
		@InjectMocks
		private ItemController itemsController;
		/**readAllTest is a test to determine whether the readAll function works
		 *
		 */
		@Test
		public void readAllTest() {
			ItemController itemsController = new ItemController(itemServices);
			List<Item> Items = new ArrayList<>();
			Items.add(new Item("Beans", 1.99));
			Items.add(new Item("Robinson", 3.45));
			Items.add(new Item("Tea", 3.79));
			Mockito.when(itemServices.readAll()).thenReturn(Items);
			assertEquals(Items, itemsController.readAll());
		}
		

		@Test
		public void deleteTest() {
			String id = "1";
			Mockito.doReturn(id).when(itemsController).getInput();
			itemsController.delete();
			Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
		}
	}


