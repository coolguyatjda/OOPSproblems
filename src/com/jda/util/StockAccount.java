package com.jda.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StockAccount {
	private double value = 0;
	private ArrayList<String> stock = new ArrayList<>();
	private String fileName;
	public StockAccount(String filename) {
		// TODO Auto-generated constructor stub
		File file = new File(filename);
		this.fileName = filename;
	}
	public void value(int value){
		this.value = value;
	}
	public double valueOf(){
		return this.value;
	}
	public void buy(double amount, String symbol){
		this.stock.add(symbol + ":" + amount);
		this.value -= amount;
	}
	public void sell(double amount, String symbol){
		for(int i=0; i<stock.size(); i++){
			if(stock.get(i).split(":")[0].equals(symbol)){
				stock.remove(i);
				break;
			}
		}
		this.value += amount;
	}
	public void save() throws IOException{
		File file = new File(this.fileName);
		FileWriter fw = new FileWriter(this.fileName);
		for(int i=0; i<stock.size(); i++)
			fw.write(stock.get(i) + "\n"); 
		fw.close();
	}
	public void printReport(){
		
	}

}
