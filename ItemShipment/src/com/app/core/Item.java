package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Comparable<Item>,Serializable{
	private String itemCode;
	private String desc;
	private double price;
	private LocalDate shipmentDate;
	
	
	
	public Item() {
		super();
	}
	public Item(String itemCode, String desc, double price, LocalDate shipmentDate) {
		super();
		this.itemCode = itemCode;
		this.desc = desc;
		this.price = price;
		this.shipmentDate = shipmentDate;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", desc=" + desc + ", price=" + price + ", shipmentDate=" + shipmentDate
				+ "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Item)
		{
			Item i=(Item)o;
			return this.itemCode.equals(i.itemCode);
		}
		return false;
	}
	@Override
	public int compareTo(Item o) {
		
		return this.itemCode.compareTo(o.itemCode);
	}
	
}
