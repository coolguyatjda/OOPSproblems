package com.jda.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.jda.util.CompanyShares;
import com.jda.util.InputUtil;
import com.jda.util.Stock;
import com.jda.util.StockAccount;

public class FifthMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		String path = "/home/bridgelabz/workspace/OOPS/src/com/jda/util/ThirdProb.json";
		ArrayList<Stock> companies = mapper.readValue(new File(path), new TypeReference<ArrayList<Stock>>() {});
		while(true){
			System.out.println("1. Create New StockAccount");
			System.out.println("2. Access Existing Stock Account");
			System.out.println("3. Quit");
			int num = Integer.parseInt(InputUtil.getString());
			if(num == 3)
				break;
			System.out.println("Give The Account Name");
			String filename = InputUtil.getString();
			StockAccount sa = new StockAccount(filename);
			editaccount(sa, companies);
		}
	}
	public static void editaccount(StockAccount sa, ArrayList<Stock> companies) throws IOException{
		while(true){
			System.out.println("1. Get the ValueOf the Account");
			System.out.println("2. Buy a Stock");
			System.out.println("3. Sell a Stock");
			System.out.println("4. Print Report");
			System.out.println("5. Save and Go Back");
			int num = Integer.parseInt(InputUtil.getString());
			switch(num){
			case 1: {
				System.out.println(sa.valueOf());
				break;
			}
			case 2: {
				System.out.println("Select One Of The following Companies");
				for(int i=0; i<companies.size(); i++){
					System.out.print(companies.get(i).getName() + " ");
				}
				System.out.println();
				System.out.print("Give the symbol: ");
				String symbol = InputUtil.getString();
				System.out.print("Give the amount: ");
				double amount = Double.parseDouble(InputUtil.getString());
				sa.buy(amount, symbol);
				break;
			}
			case 3: {
				System.out.println("Select One Of The following Companies");
				for(int i=0; i<sa.getList().size(); i++){
					System.out.print(sa.getList().get(i).getSymbol() + " ");
				}
				System.out.println();
				System.out.print("Give the symbol: ");
				String symbol = InputUtil.getString();
				System.out.print("Give the amount: ");
				double amount = Double.parseDouble(InputUtil.getString());
				sa.sell(amount, symbol);
				break;
			}
			case 4: {
				sa.printReport();
				break;
			}
			case 5: {
				sa.save();
				break;
			}
			}
			if(num == 5){
				sa.save();
				break;
			}
		}
	}

}
