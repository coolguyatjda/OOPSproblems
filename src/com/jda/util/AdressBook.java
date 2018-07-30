package com.jda.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class AdressBook {
   private String fileName;
	private List<Person> persons = new ArrayList<>();
	
	public AdressBook(String fileName) {
		this.fileName = fileName;
		File file = new File(this.fileName);
	}
	public String getFileName(){
		return this.fileName;
	}
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public void writeToFile() throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		String arrayToJson = mapper.writeValueAsString(persons);
		FileWriter fw = new FileWriter(this.fileName);
		fw.write(arrayToJson);
		fw.close();
	}
	public void readFromFile(){
		ObjectMapper mapper = new ObjectMapper();
		try{
			this.persons = mapper.readValue(new File(this.fileName), new TypeReference<ArrayList<Person>>() {});
		}catch(IOException e){
			this.persons = new ArrayList<Person>();
		}
		
	}
	
	public void printAll(){
		for(int i=0; i<persons.size(); i++){
			System.out.print(persons.get(i).getName() + " ");
			System.out.print(persons.get(i).getAddress() + " ");
			System.out.print(persons.get(i).getCity() + " ");
			System.out.print(persons.get(i).getState() + " ");
			System.out.print(persons.get(i).getZip() + " ");
			System.out.println(persons.get(i).getpno() + " ");
		}
	}
	private String lastName(String Name){
		String[] strs = Name.split(" ");
		return strs[1];
	}
	
	public void sortName() throws IOException{
		for(int i=0; i<persons.size()-1; i++){
			for(int j=i+1; j<persons.size(); j++){
				if(lastName(persons.get(i).getName()).compareTo(lastName(persons.get(j).getName())) > 0){
					Person p1 = persons.get(i);
					Person p2 = persons.get(j);
					Person temp = p1;
					p1 = p2;
					p2 = temp;
				}
			}
		}
		this.writeToFile();
		for(int i=0; i<persons.size(); i++)
			System.out.println(persons.get(i).toString());
	}
	
	public void sortZip() throws IOException{
		for(int i=0; i<persons.size()-1; i++){
			for(int j=i+1; j<persons.size(); j++){
				if(persons.get(i).getZip() > persons.get(j).getZip()){
					Person p1 = persons.get(i);
					Person p2 = persons.get(j);
					Person temp = p1;
					p1 = p2;
					p2 = temp;
				}
			}
		}
		this.writeToFile();
		for(int i=0; i<persons.size(); i++)
			System.out.println(persons.get(i).toString());
	}
	
	public void createEntry(){
		Person person = new Person();
		System.out.print("Give user Name : ");	
		person.setName(InputUtil.getString());
		//System.out.println();
		System.out.print("Give Address : ");
		person.setAddress(InputUtil.getString());
		//System.out.println();
		System.out.print("Give City : ");
		person.setCity(InputUtil.getString());
		//System.out.println();
		System.out.print("Give State : ");
		person.setState(InputUtil.getString());
		//System.out.println();
		System.out.print("Give Zip : ");
		person.setZip(Integer.parseInt(InputUtil.getString()));
		System.out.print("Give PhoneNumber : ");
		person.setpno(Long.parseLong(InputUtil.getString()));
		//System.out.println();
		persons.add(person);
	}
	public void editEntry(String Name){
		Person person = null;
		for(int i=0; i<persons.size(); i++)
			if(persons.get(i).getName().equals(Name))
				person = persons.get(i);
		System.out.print("Give Address : ");
		String temp = InputUtil.getString();
		if(!temp.equals( "NA"))
		person.setAddress(temp);
		System.out.print("Give City : ");
		temp = InputUtil.getString();
		if(temp.equals( "NA") == false)
		person.setCity(temp);
		System.out.println("Give State : ");
		temp = InputUtil.getString();
		if(temp.equals( "NA") == false)
		person.setState(temp);
		System.out.print("Give Zip : ");
		int zip = Integer.parseInt(InputUtil.getString());
		if(zip != 0)
		person.setZip(zip);
		System.out.println("Give PhoneNumber");
		long p_no = Long.parseLong(InputUtil.getString());
		if(p_no != 0)
		person.setpno(p_no);
	}
	public void deleteUser(String Name){
		for(int i=0; i<persons.size(); i++)
			if(persons.get(i).getName().equals(Name))
				persons.remove(i);
	}

}
