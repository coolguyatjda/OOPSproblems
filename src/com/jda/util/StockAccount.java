package com.jda.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class StockAccount {
	private double value = 0;
	private List<CompanyShares> stock;
	private String fileName;
	ObjectMapper mapper = new ObjectMapper();
	public StockAccount(String filename) {
		// TODO Auto-generated constructor stub
		File file = new File("/home/bridgelabz/workspace/OOPS/src/com/jda/util/" + filename);
		this.fileName = filename;
		try{
			stock = mapper.readValue(new File(this.fileName), new TypeReference<ArrayList<CompanyShares>>() {});
		}catch(Exception e){
			stock = new ArrayList<>();
		}
	}
	public List<CompanyShares> getList(){
		return this.stock;
	}
	public void value(int value){
		this.value = value;
	}
	public double valueOf(){
		return this.value;
	}
	public void buy(double amount, String symbol){
		this.stock.add(new CompanyShares(symbol, (int)amount));
		this.value -= amount;
	}
	public void sell(double amount, String symbol){
		for(int i=0; i<stock.size(); i++){
			if(stock.get(i).getSymbol().equals(symbol)){
				stock.get(i).setNumberOfShares(stock.get(i).getNumberOfShares() -(int) amount);
				break;
			}
		}
		this.value += amount;
	}
	public void save() throws IOException{
		FileWriter fw = new FileWriter("/home/bridgelabz/workspace/OOPS/src/com/jda/util/" + this.fileName);
		fw.write(mapper.writeValueAsString(this.stock));
		fw.close();
	}
	public void printReport(){
		System.out.println("Hi");
	}

}
