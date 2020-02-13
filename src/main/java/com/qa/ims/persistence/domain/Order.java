package com.qa.ims.persistence.domain;

public class Order {
	
	

		private Long id;
		private Long Quantity;
		private double Price;
		private Long Customer_id;
		

		public Order(Long Quantity, double price2, Long quantity2, Long customer_id2) {
			this.Quantity = Quantity;
			
		}

		public Order(Long id, Long Quantity, double Price, Long Customer_id) {
			this.id = id;
			this.Quantity = Quantity;
			this.Price = Price;
			this.Customer_id = Customer_id;
			
		}

		public Long getQuantity() {
			return Quantity;
		}

		public void setQuantity(Long quantity) {
			Quantity = quantity;
		}

		public Long getCustomer_id() {
			return Customer_id;
		}

		public void setCustomer_id(Long customer_id) {
			Customer_id = customer_id;
		}

		public void setPrice(double price) {
			Price = price;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public String toString() {
			return "id:" + id + " Quantity:" + Quantity + " Price:" + Price + " Customer ID" + Customer_id;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Customer_id == null) ? 0 : Customer_id.hashCode());
			long temp;
			temp = Double.doubleToLongBits(Price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((Quantity == null) ? 0 : Quantity.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			if (Customer_id == null) {
				if (other.Customer_id != null)
					return false;
			} else if (!Customer_id.equals(other.Customer_id))
				return false;
			if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
				return false;
			if (Quantity == null) {
				if (other.Quantity != null)
					return false;
			} else if (!Quantity.equals(other.Quantity))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

	}


