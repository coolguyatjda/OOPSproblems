package com.jda.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;


public class Manager {
//	private ArrayList<AdressBook> adressbooks = new ArrayList<>();
	public void createAddBook(String fileName) throws IOException{
		AdressBook ad = new AdressBook(fileName);
		ad.createNewFile();
	//	adressbooks.add(ad);
	}
	
	public ArrayList<String> listOfAB(){
		File folder 	= new File("/home/bridgelabz/workspace/OOPS");
		File[] allFiles = folder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.toLowerCase().endsWith(".json");
			}
		});
		ArrayList<String> files = new ArrayList<>();
		for(int i=0; i<allFiles.length; i++){
			files.add(allFiles[i].getName());
		}
		return files;
	}
	
	public AdressBook openFile(String fileName){
		return new AdressBook(fileName);
	}
	
	
//	public void saveAs(String fileName, String newName){
//		for(int i=0; i<adressbooks.size(); i++){
//			if(adressbooks.get(i).getFileName().equals(fileName)){
//				adressbooks.get(i).setFileName(fileName);
//				return;
//			}
//		}
//	}
}

