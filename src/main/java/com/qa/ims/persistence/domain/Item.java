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
}