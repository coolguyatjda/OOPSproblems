package com.jda.core;

import java.io.FileWriter;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import com.jda.util.InputUtil;

public class Inventory {
	
	public class Product{
		public String name;
		public int weight;
		public int pricePerKG;
		public Product(String name, int weight, int pricePerKG) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.weight = weight;
			this.pricePerKG = pricePerKG;
		}
	}

	public static void main(String[] args) throws Exception{
		String[] products = {"Rice", "Pulse", "Wheat"};
		// TODO Auto-generated method stub
		System.out.print("Enter the KG Of Rice: ");
		int kgofrice = InputUtil.getInt();
		System.out.print("Enter the PricePerKG Of Rice: ");
		int priceofrice = InputUtil.getInt();
		System.out.print("Enter the KG Of Pulse: ");
		int kgofpulse = InputUtil.getInt();
		System.out.print("Enter the PricePerKG Of Pulse: ");
		int priceofpulse = InputUtil.getInt();
		System.out.print("Enter the KG Of Wheat: ");
		int kgofwheat = InputUtil.getInt();
		System.out.print("Enter the PricePerKG Of Wheat: ");
		int priceofwheat = InputUtil.getInt();
		ArrayList<Product> inv = new ArrayList<>();
		inv.add(new Inventory().new Product(products[0], kgofrice, priceofrice));
		inv.add(new Inventory().new Product(products[1], kgofpulse, priceofpulse));
		inv.add(new Inventory().new Product(products[2], kgofwheat, priceofwheat));		
		ObjectMapper mapper = new ObjectMapper();
		String value = mapper.writeValueAsString(inv);
		FileWriter fw = new FileWriter("/home/bridgelabz/workspace/OOPS/src/com/jda/util/Inventory.json");
		fw.write(value);
		fw.close();
		int vor = kgofrice*priceofrice;
		int vop = kgofpulse*priceofpulse;
		int vow = kgofwheat*priceofwheat;
		int tv= vor+vop+vow;
		System.out.println("The value of Rice: " + vor);
		System.out.println("The value of Rice: " + vop);
		System.out.println("The value of Rice: " + vow);
		System.out.println("The total value is: " + tv);
	}

}
