package com.jda.core;

import java.io.IOException;
import java.util.List;

import com.jda.util.Patient;
import com.jda.util.Utility;

public class UtilityMain {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
	List<Patient> ll =  new Utility<Patient>().read("/home/bridgelabz/workspace/OOPS/src/com/jda/util/Patients.json", Patient.class);
//		List<Doctor> ll = new ObjectMapper().readValue(new File("/home/bridgelabz/workspace/OOPS/src/com/jda/util/Doctors.json"), new TypeReference<ArrayList<Doctor>>() {});
		for(int i=0; i<ll.size();  i++){
			System.out.println(ll.get(i).getName());
		}
	}

}
