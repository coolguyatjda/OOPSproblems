package com.jda.core;

import java.io.IOException;

import com.jda.util.AdressBook;
import com.jda.util.InputUtil;
import com.jda.util.Manager;

public class MainMethod {

	private static final Manager m1 = new Manager();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		while(true){
			System.out.println("1. Create A New File");
			System.out.println("2. Open Existing File");
			System.out.println("3. Quit");
			int i = InputUtil.getInt();
			switch(i){
			case 1: {
				createNewFile();
				break;
			}
			case 2:{
				System.out.println("Give the fileName");
				String fileName = InputUtil.getString();
				editFile(fileName);
				break;
			}
			}
			if(i == 3)
				break;
			}
		}
	public static void createNewFile() throws IOException{
		System.out.println("Filename: ");
		String fileName = InputUtil.getString();
		m1.createAddBook(fileName);
		editFile(fileName);
	}
	public static void editFile(String fileName){
		AdressBook ab = m1.openFile(fileName);
		while(true){
			System.out.println("1. Create User");
			System.out.println("2. Edit User");
			System.out.println("3. Delete User");
			System.out.println("4. Sort the Entries with Last Name");
			System.out.println("5. Sort the Entries with Zip");
			System.out.println("6. Save and Go back to Previous Menu");
			int i = InputUtil.getInt();
			switch(i){
				case 1: {
					
					
				}
			}
		}
	} 
}
