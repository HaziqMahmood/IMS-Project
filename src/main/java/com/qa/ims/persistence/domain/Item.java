package com.qa.ims.persistence.domain;

public class Item {
	private long id;
	private String item_name;
	private Double cost;
public Item( String item_name, Double cost) {
	this.item_name = item_name;
	this.cost = cost;		
	}
public Item(Long id, String item_name, Double cost) {
	this.id=id;
	this.item_name = item_name;
	this.cost = cost;
}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Double getItem_value() {
		return cost;
	}
	public Double setItem_value(Double cost) {
		return cost;
	}
	public String toString() {
		return "id:" + id + " item_name:" + item_name + " cost:" + cost;
	}
	public static void add(Item items) {
		

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
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
		Item other = (Item) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		return true;
	}
	
	
	
}