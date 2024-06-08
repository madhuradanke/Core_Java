package com.app;

import java.time.LocalDate;

public class Pen {
	private int penId;
	private static int id;
	static {
		id=1;
	}
	private String brand;
	private String color;
	private String inkColor;
	private Material material;
	private int stock;
	private LocalDate stockUpdate;
	private LocalDate listingDate;
	private double price;
	private double discounts;
	
	//constr
	public Pen() {
		super();
	}

	public Pen(String brand, String color, String inkColor, Material material, int stock, double price,
			double discounts,LocalDate listingDate) {
		super();
		this.penId=id;
		id++;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.price = price;
		this.discounts = discounts;
		this.listingDate=listingDate;
		this.stockUpdate=LocalDate.now();
	}
	//getters and setters

	public int getPenId() {
		return penId;
	}

	public void setPenId(int penId) {
		this.penId = penId;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Pen.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getStockUpdate() {
		return stockUpdate;
	}

	public void setStockUpdate(LocalDate stockUpdate) {
		this.stockUpdate = stockUpdate;
	}

	public LocalDate getListingDate() {
		return listingDate;
	}

	public void setListingDate(LocalDate listingDate) {
		this.listingDate = listingDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(double discounts) {
		this.discounts = discounts;
	}

	//toString
	@Override
	public String toString() {
		return "Pen [penId=" + penId + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor
				+ ", material=" + material + ", stock=" + stock + ", stockUpdate=" + stockUpdate + ", listingDate="
				+ listingDate + ", price=" + price + ", discounts=" + discounts + "]";
	}
	

}
