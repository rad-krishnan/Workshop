package com.RKShopping.ShoppingDetails.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_react")

public class Product {
	
	@Id
//	@GeneratedValue
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Quantity")
	private int Quantity;
	
	@Column(name = "Price")
	private double Price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public Product(int id, String name, int quantity, double price) {
		super();
		this.id = id;
		Name = name;
		Quantity = quantity;
		Price = price;
	}
	
	public Product() {
		
	}
}