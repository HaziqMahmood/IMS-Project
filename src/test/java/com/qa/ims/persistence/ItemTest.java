package com.qa.ims.persistence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.qa.ims.persistence.domain.Item;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	
	
	
		private Item item;
		private Item other;
		@Before
		public void setUp() {
			item = new Item(1L, "Mug",4.75);
			other = new Item(1L, "Mug", 4.75);
		
		}
		@Test
		public void equalsWithNull() {
			assertFalse(item.equals(null));
		}
		@Test
		public void equalsWithDifferentObject() {
			assertFalse(item.equals(new Object()));
		}
		@Test
		public void createitemsWithId() {
			assertEquals(1L, item.getId(), 0);
			assertEquals("Mug", item.getItem_name());
			assertEquals(4.75, item.getItem_value(),0);
		}
		@Test
		public void checkEquality() {
			assertTrue(item.equals(item));
		}

		@Test
		public void itemsNameNullButOtherNameNotNull() {
			item.setItem_name(null);
			assertFalse(item.equals(other));
		}
		@Test
		public void itemsNamesNotEqual() {
			other.setItem_name("");
			assertFalse(item.equals(other));
		}

		@Test
		public void nullId() {
			item.setId(0);
			assertFalse(item.equals(other));
		}

		@Test
		public void otherIdDifferent() {
			other.setId(2);
			assertFalse(item.equals(other));
		}
		@Test
		public void nullItem_name() {
			item.setItem_name(null);
			assertFalse(item.equals(other));
		}

		@Test
		public void otherItem_nameDifferent() {
			other.setItem_name("Haggis");
			assertFalse(item.equals(other));
		}


		@Test
		public void hashCodeTest() {
			assertEquals(item.hashCode(), other.hashCode());
		}
		@Test
		public void hashCodeTestWithNull() {
			Item item = new Item(null, null);
			Item other = new Item(null, null);
			assertEquals(item.hashCode(), other.hashCode());
		}
		@Test
		public void toStringTest() {
			String toString = "id:1 item_name:Mug cost:4.75";
			assertEquals(toString, item.toString());
		}
	}