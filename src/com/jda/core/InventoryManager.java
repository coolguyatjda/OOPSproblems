package com.jda.core;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.jda.core.Inventory.Product;
import com.jda.util.InputUtil;

public class InventoryManager {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Enter Number of Stocks");
		int N = InputUtil.getInt();
		String garbage =  InputUtil.getString();
		ObjectMapper mapper = new ObjectMapper();
		String filePath = "/home/bridgelabz/workspace/OOPS/src/com/jda/util/Inventory.json";
		ArrayList<Inventory.Product> stock;
		try{
			stock = mapper.readValue(new File(filePath),new TypeReference<ArrayList<Inventory.Product>>(){});
		}catch(Exception e){
			stock = new ArrayList<>();
		}
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
		String str = mapper.writeValueAsString(stock);
		FileWriter fw = new FileWriter(filePath);
		fw.write(str);
		fw.close();
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
