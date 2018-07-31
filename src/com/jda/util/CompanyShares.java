package com.jda.util;

import java.text.SimpleDateFormat;

public class CompanyShares {
	private String symbol;
	private int numberOfShares;
	private String date;
	
	public CompanyShares() {
		// TODO Auto-generated constructor stub
	}
	public CompanyShares(String symbol, int numberOfShares) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.numberOfShares = numberOfShares;
		this.date = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public String getDate() {
		return date;
	}
	public void setDate() {
		this.date = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
	}
	

}
