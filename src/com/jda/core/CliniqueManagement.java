package com.jda.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

import com.jda.util.Doctor;
import com.jda.util.InputUtil;
import com.jda.util.Patient;
import com.jda.util.Utility;

public class CliniqueManagement {
	private static List<Doctor> doctors;
	private static List<Patient> patients;
	private static ObjectMapper mapper = new ObjectMapper();
	private static String path1 = "/home/bridgelabz/workspace/OOPS/src/com/jda/util/Doctors.json";
	private static String path2 = "/home/bridgelabz/workspace/OOPS/src/com/jda/util/Patients.json";
	
	public static void addDoctor() throws IOException{
		doctors = new Utility<Doctor>().read(path1, Doctor.class);
		Doctor d = new Doctor();
		System.out.print("Give the Name: ");
		d.setName(InputUtil.getString());
		System.out.print("Give the id: ");
		d.setID(Integer.parseInt(InputUtil.getString()));
		System.out.print("Give the Specialization: ");
		d.setSpecialization(InputUtil.getString());
		System.out.print("Give the Availability");
		d.setAvailability(InputUtil.getString());
		doctors.add(d);
	}
	
	public static void addPatient() throws IOException{
		patients = new Utility<Patient>().read(path2, Patient.class);
		Patient d = new Patient();
		System.out.print("Give the Name: ");
		d.setName(InputUtil.getString());
		System.out.print("Give the id: ");
		d.setID(Integer.parseInt(InputUtil.getString()));
		System.out.print("Give the MobileNumber: ");
		d.setMobileNumber(Long.parseLong(InputUtil.getString()));
		System.out.print("Give the Age");
		d.setAge(Integer.parseInt(InputUtil.getString()));
		patients.add(d);
	}
	
	public static void searchD(){
		System.out.println("1. Search By Name");
		System.out.println("2. Search By ID");
		System.out.println("3. Search by Specialization");
		System.out.println("4. Search by Availability");
		int inp1 = Integer.parseInt(InputUtil.getString());
		switch(inp1) {
		case 1: searchDByName(InputUtil.getString()); break;
		case 2: searchDByID(Integer.parseInt(InputUtil.getString())); break;
		case 3: searchDBySpecialization(InputUtil.getString()); break;
		case 4: searchDByAvailability(InputUtil.getString()); break;
		}
	}
	
	public static void searchP(){
		System.out.println("1. Search By Name");
		System.out.println("2. Search By MobileNumber");
		System.out.println("3. Search by ID");
		int inp1 = Integer.parseInt(InputUtil.getString());
		switch(inp1) {
		case 1: searchPByName(InputUtil.getString()); break;
		case 2: searchPByMobileNumber(Long.parseLong(InputUtil.getString())); break;
		case 3: searchPByID(Integer.parseInt(InputUtil.getString())); break;
	}
	}
	public static void searchDByName(String name) {
		for(int i=0; i<doctors.size(); i++) {
			if(name.equals(doctors.get(i).getName())) {
				System.out.println(doctors.get(i).getName());
				System.out.println(doctors.get(i).getID());
				System.out.println(doctors.get(i).getSpecialization());
				System.out.println(doctors.get(i).getAvailability());
			}
			System.out.println();
		}
	}
	public static void searchDByID(int id) {
		for(int i=0; i<doctors.size(); i++) {
			if(doctors.get(i).getID() == id) {
				System.out.println(doctors.get(i).getName());
				System.out.println(doctors.get(i).getID());
				System.out.println(doctors.get(i).getSpecialization());
				System.out.println(doctors.get(i).getAvailability());
			}
			System.out.println();
		}
	}
	public static void searchDBySpecialization(String specialization) {
		for(int i=0; i<doctors.size(); i++) {
			if(specialization.equals(doctors.get(i).getSpecialization())) {
				System.out.println(doctors.get(i).getName());
				System.out.println(doctors.get(i).getID());
				System.out.println(doctors.get(i).getSpecialization());
				System.out.println(doctors.get(i).getAvailability());
			}
			System.out.println();
		}
	}
	public static void searchDByAvailability(String availability) {
		for(int i=0; i<doctors.size(); i++) {
			if(availability.equals(doctors.get(i).getAvailability())) {
				System.out.println(doctors.get(i).getName());
				System.out.println(doctors.get(i).getID());
				System.out.println(doctors.get(i).getSpecialization());
				System.out.println(doctors.get(i).getAvailability());
			}
			System.out.println();
		}
	}
	public static void searchPByName(String name) {
		for(int i=0; i<patients.size(); i++) {
			if(name.equals(patients.get(i).getName())) {
				System.out.println(patients.get(i).getName());
				System.out.println(patients.get(i).getID());
				System.out.println(patients.get(i).getMobileNumber());
				System.out.println(patients.get(i).getAge());
			}
			System.out.println();
		}
	}
	public static void searchPByID(int id) {
		for(int i=0; i<patients.size(); i++) {
			if(patients.get(i).getID() == id) {
				System.out.println(patients.get(i).getName());
				System.out.println(patients.get(i).getID());
				System.out.println(patients.get(i).getMobileNumber());
				System.out.println(patients.get(i).getAge());
			}
			System.out.println();
		}
	}
	public static void searchPByMobileNumber(long mobileNumber) {
		for(int i=0; i<patients.size(); i++) {
			if(patients.get(i).getMobileNumber() == mobileNumber) {
				System.out.println(patients.get(i).getName());
				System.out.println(patients.get(i).getID());
				System.out.println(patients.get(i).getMobileNumber());
				System.out.println(patients.get(i).getAge());
			}
			System.out.println();
		}
	}
	public static void saveAndQuit() throws IOException{
		File file1 = new File(path1);
		File file2 = new File(path2);
		FileWriter fwd = new FileWriter(file1);
		fwd.write(mapper.writeValueAsString(doctors));
		fwd.close();
		FileWriter fwp = new FileWriter(file2);
		fwp.write(mapper.writeValueAsString(patients));
		fwp.close();
	}
	public static void takeAppointment(String dName, String pName) throws IOException{
		FileWriter fw = new FileWriter(new File(dName + ".json"));
		fw.write(pName + "\n");
		fw.close();
	}
	public static void printeReport(String dName) throws IOException{
		Scanner sc = new Scanner(new File(dName));
		while(sc.hasNextLine())
			for(int i=1; i<=5; i++)
				System.out.println(i + " " + sc.nextLine());
		sc.close();
	}	

}
