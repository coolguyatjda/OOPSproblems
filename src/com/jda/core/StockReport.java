package com.jda.core;

import java.util.ArrayList;

import com.jda.util.InputUtil;

public class StockReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Number of Stocks");
		int N = InputUtil.getInt();
		String garbage =  InputUtil.getString();
		ArrayList<Inventory.Product> stock = new ArrayList<>();
		for(int i=0; i<N; i++){
			System.out.println("Give Stock Name");
			String name = InputUtil.getString();
			System.out.println("Give Number Of Stock");
			int number = InputUtil.getInt();
			System.out.println("Give Stock price");
			int price = InputUtil.getInt();
			stock.add(new Inventory().new Product(name, number, price));
			garbage = InputUtil.getString();
		}
		int totalvalue =  0;
		for(int i=0; i<N; i++){
			System.out.println("For stock item " + stock.get(i).name  + ":  ");
			int value = stock.get(i).weight*stock.get(i).pricePerKG;
			System.out.println("value: " + value);
			totalvalue += value;
		}
		System.out.println("Total value of Stock: " + totalvalue);

	}

}
