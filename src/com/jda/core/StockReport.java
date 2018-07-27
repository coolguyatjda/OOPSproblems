package com.jda.core;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.jda.util.InputUtil;
import com.jda.util.Stock;

public class StockReport {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Enter Number of Stocks");
		ObjectMapper mapper = new ObjectMapper();
		String path = "/home/bridgelabz/workspace/OOPS/src/com/jda/util/ThirdProb.json";
		int N = Integer.parseInt(InputUtil.getString());
		List<Stock> stocks;
		try{
			stocks = mapper.readValue(new File(path), new TypeReference<ArrayList<Stock>>() {});
		}catch(Exception e){
			stocks = new ArrayList<>();
		}
		for(int i=0; i<N; i++){
			System.out.print("Give Stock Name: ");
			String name = InputUtil.getString();
			System.out.print("Give Number Of Stock");
			int number = Integer.parseInt(InputUtil.getString());
			System.out.print("Give Stock price");
			double price = Double.parseDouble(InputUtil.getString());
			stocks.add(new Stock(name, number, price));
		}
		File file = new File(path);
		FileWriter fw = new FileWriter(file);
		fw.write(mapper.writeValueAsString(stocks));
		fw.close();
		int totalvalue =  0;
		for(int i=0; i<N; i++){
			System.out.println("For stock item " + stocks.get(i).getName()  + ":  ");
			double value = (double)stocks.get(i).getTotalShares()*stocks.get(i).getPrice();
			System.out.println("value: " + value);
			totalvalue += value;
		}
		System.out.println("Total value of Stock: " + totalvalue);

	}

}
