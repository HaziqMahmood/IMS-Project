//package com.qa.ims.persistence;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.qa.ims.persistence.domain.Customer;
//
//public class CustomerTest {
//	
//
//		private Customer customer;
//		private Customer other;
//		@Before
//		public void setUp() {
//			customer = new Customer(1L, "Haziq", "Mahmood");
//			other = new Customer(1L, "Haziq", "Mahmood");
//		}
//		@Test
//		public void settersTest() {
//			assertNotNull(customer.getId());
//			assertNotNull(customer.getFirstName());
//			assertNotNull(customer.getSurname());
//			customer.setId(null);
//			assertNull(customer.getId());
//			customer.setFirstName(null);
//			assertNull(customer.getFirstName());
//			customer.setSurname(null);
//			assertNull(customer.getSurname());
//		}
//		@Test
//		public void equalsWithNull() {
//			assertFalse(customer.equals(null));
//		}
//		@Test
//		public void equalsWithDifferentObject() {
//			assertFalse(customer.equals(new Object()));
//		}
//		@Test
//		public void createCustomerWithId() {
//			assertEquals(1L, customer.getId(), 0);
//			assertEquals("Haziq", customer.getFirstName());
//			assertEquals("Mahmood", customer.getSurname());
//		}
//		@Test
//		public void checkEquality() {
//			assertTrue(customer.equals(customer));
//		}
//		@Test
//		public void checkEqualityBetweenDifferentObjects() {
//			assertTrue(customer.equals(other));
//		}
//		@Test
//		public void customerNameNullButOtherNameNotNull() {
//			customer.setFirstName(null);
//			assertFalse(customer.equals(other));
//		}
//		@Test
//		public void customerNamesNotEqual() {
//			other.setFirstName("ali");
//			assertFalse(customer.equals(other));
//		}
//		@Test
//		public void checkEqualityBetweenDifferentObjectsNullName() {
//			customer.setFirstName(null);
//			other.setFirstName(null);
//			assertTrue(customer.equals(other));
//		}
//		@Test
//		public void nullId() {
//			customer.setId(null);
//			assertFalse(customer.equals(other));
//		}
//		@Test
//		public void nullIdOnBoth() {
//			customer.setId(null);
//			other.setId(null);
//			assertTrue(customer.equals(other));
//		}
//		@Test
//		public void otherIdDifferent() {
//			other.setId(2L);
//			assertFalse(customer.equals(other));
//		}
//		@Test
//		public void nullSurname() {
//			customer.setSurname(null);
//			assertFalse(customer.equals(other));
//		}
//		@Test
//		public void nullSurnameOnBoth() {
//			customer.setSurname(null);
//			other.setSurname(null);
//			assertTrue(customer.equals(other));
//		}
//		@Test
//		public void otherSurnameDifferent() {
//			other.setSurname("john");
//			assertFalse(customer.equals(other));
//		}
//		@Test
//		public void constructorWithoutId() {
//			Customer customer = new Customer("Haziq", "Mahmood");
//			assertNull(customer.getId());
//			assertNotNull(customer.getFirstName());
//			assertNotNull(customer.getSurname());
//		}
//		@Test
//		public void hashCodeTest() {
//			assertEquals(customer.hashCode(), other.hashCode());
//		}
//		@Test
//		public void hashCodeTestWithNull() {
//			Customer customer = new Customer(null, null);
//			Customer other = new Customer(null, null);
//			assertEquals(customer.hashCode(), other.hashCode());
//		}
//		@Test
//		public void toStringTest() {
//			String toString = "id:1 forename:Haziq surname:Mahmood";
//			assertEquals(toString, customer.toString());
//		}
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((customer == null) ? 0 : customer.hashCode());
//			result = prime * result + ((other == null) ? 0 : other.hashCode());
//			return result;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			CustomerTest other = (CustomerTest) obj;
//			if (customer == null) {
//				if (other.customer != null)
//					return false;
//			} else if (!customer.equals(other.customer))
//				return false;
//			if (this.other == null) {
//				if (other.other != null)
//					return false;
//			} else if (!this.other.equals(other.other))
//				return false;
//			return true;
//		}
//		
//		
//	}

	
	
	