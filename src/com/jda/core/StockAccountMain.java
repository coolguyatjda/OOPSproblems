package com.jda.core;

import java.io.IOException;
import java.util.ArrayList;

import com.jda.util.InputUtil;
import com.jda.util.StockAccount;

public class StockAccountMain {

	public class Stock{
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		ArrayList<StockAccount> sacs = new ArrayList<>();
		System.out.println("Give the Number Of Stock Accounts");
		int N = Integer.parseInt(InputUtil.getString());
		for(int i=0; i<N; i++){
			System.out.println("Give Account Name");
			String filename = InputUtil.getString();
			StockAccount sc = new StockAccount(filename);
			while(true){
				System.out.println("1. Check The Value Of The Account");
				System.out.println("2. Buy a Stock");
				System.out.println("3. Sell a Stock");
				System.out.println("4. Save And Go Back");
				int inp = Integer.parseInt(InputUtil.getString());
				switch(inp){
				case 1: {
					System.out.println(sc.valueOf());
					break;
				}
				case 2: {
					System.out.print("Enter The Name: ");
					String symbol = InputUtil.getString();
					System.out.print("Enter The Amount: ");
					double amount = Double.parseDouble(InputUtil.getString());
					sc.buy(amount, symbol);
					break;
				}
				case 3: {
					System.out.print("Enter The Name: ");
					String symbol = InputUtil.getString();
					System.out.print("Enter The Amount: ");
					double amount = Double.parseDouble(InputUtil.getString());
					sc.sell(amount, symbol);
					break;
				}
				case 4: {
					sc.save();
					break;
				}
				}
				if(inp == 4)
					break;
			}
		}

	}

}
