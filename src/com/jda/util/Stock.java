package com.jda.util;

public class Stock {
	private String name;
	private int totalShares;
	private double price;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	public Stock(String name, int totalShares, double price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.totalShares= totalShares;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
