package com.jda.util;

import java.io.File;
import java.io.IOException;


public class Manager {
	
	private AdressBook addressBook;
	
	public void createAddBook(String fileName) throws IOException{
		 addressBook = new AdressBook(fileName);
		//ad.writeToFile();
	//	adressbooks.add(ad);
	}
	
	public void listOfAB(){
		File folder 	= new File("/home/bridgelabz/workspace/OOPS/src/com/jda/util/AdressFolder/");
		File[] allFiles = folder.listFiles();
//		ArrayList<String> files = new ArrayList<>();
		for(File f : allFiles){
			System.out.print(f.getName() + " ");
		}
		System.out.println();
	}
	
	public AdressBook openFile(String fileName){
		return new AdressBook(fileName);
	}
	public void save(AdressBook ab) throws IOException{
		ab.writeToFile();
	}
	public void saveAs(String path1,  String path2){
		File file1 = new File(path1);
		File file2 = file1;
	}
	public void openAB(String fileName) throws IOException{
		//this.createAddBook(fileName);
		addressBook  = new AdressBook(fileName);
		addressBook.readFromFile();
		editFile(fileName, addressBook);
	}
	
	
	private static void editFile(String fileName, AdressBook ab) throws IOException{
		ab.readFromFile();
		System.out.println(ab.getFileName());
		while(true){
			System.out.println("1. Create User" );
			System.out.println("2. Edit User");
			System.out.println("3. Delete User");
			System.out.println("4. Sort the Entries with Last Name");
			System.out.println("5. Sort the Entries with Zip");
			System.out.println("6. Save");
			System.out.println("7. Go back to Previous Menu");
			int i = Integer.parseInt(InputUtil.getString());
			switch(i){
				case 1: {
					ab.createEntry();
					break;
				}
				case 2:{
					System.out.print("Give the Name: ");
					ab.editEntry(InputUtil.getString());
					break;
				}
				case 3:{
					System.out.print("Givethe Name: ");
					ab.deleteUser(InputUtil.getString());
					break;
				}
				case 4:{
					ab.sortName();
					break;
				}
				case 5:{
					ab.sortZip();
					break;
				}
				case 6:{
					ab.writeToFile();
					break;
				}
			}
			if(i == 7){
				ab.writeToFile();
				break;
			}
		}
	} 
}

