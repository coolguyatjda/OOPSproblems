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
	private ObjectMapper mapper = new ObjectMapper();
	private static String path = "/home/bridgelabz/workspace/OOPS/src/com/jda/util/";
	private List<Stock> companies;
	public StockAccount(String filename) {
		// TODO Auto-generated constructor stub
		File file = new File(path + "stockaccounts/" + filename + ".json");
		this.fileName = filename;
		try{
			stock = mapper.readValue(new File(path + "stockaccounts/" + filename + ".json"), new TypeReference<ArrayList<CompanyShares>>() {});
			companies  = mapper.readValue(new File(path + "ThirdProb.json"), new TypeReference<ArrayList<Stock>>() {});
		}catch(Exception e){
			stock = new ArrayList<>();
			companies = new ArrayList<>();
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
		for(int i=0; i<companies.size(); i++){
			if(companies.get(i).getName().equals(symbol)){
				companies.get(i).setTotalShares(companies.get(i).getTotalShares()-(int)(amount/companies.get(i).getPrice()));
			}
			}
		this.value -= amount;
	}
	public void sell(double amount, String symbol){
		for(int i=0; i<stock.size(); i++){
			if(stock.get(i).getSymbol().equals(symbol)){
				stock.get(i).setNumberOfShares(stock.get(i).getNumberOfShares() -(int) amount);
				stock.get(i).setDate();
				break;
			}
		}
		for(int i=0; i<companies.size(); i++)
			if(companies.get(i).getName().equals(symbol))
				companies.get(i).setTotalShares(companies.get(i).getTotalShares()+(int)(amount/companies.get(i).getPrice()));
		this.value += amount;
	}
	public void save() throws IOException{
		FileWriter fw = new FileWriter(path + this.fileName + ".json");
		FileWriter fws = new FileWriter(path + "ThirdProb.json");
		fw.write(mapper.writeValueAsString(this.stock));
		fws.write(mapper.writeValueAsString(companies));
		fw.close();
		fws.close();
	}
	public void toLinkedList(){
		LinkedList<CompanyShares> companysharesLinkedList = new LinkedList<>();
		Stack<String> companysharesStack = new Stack<>();
		Queue<String> companysharesQueue = new Queue<>();
		for(CompanyShares cs : stock){
			companysharesLinkedList.add(cs);
			companysharesStack.push(cs.getSymbol());
			companysharesQueue.enqueue(cs.getDate());
		}
	}
	
	public void printReport(){
		
	}

}
