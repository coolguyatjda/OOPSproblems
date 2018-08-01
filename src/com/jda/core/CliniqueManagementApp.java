package com.jda.core;

import java.io.IOException;
import com.jda.util.InputUtil;

public class CliniqueManagementApp {

	public static void main(String[] args) throws IOException{

		while(true) {
			System.out.println("1. Add a Doctor");
			System.out.println("2. Add a Patient");
			System.out.println("3. Search for Doctors");
			System.out.println("4. Search for Patients");
			System.out.println("5. Take appointment of a Doctor");
			System.out.println("6. Print Report");
			System.out.println("7. Save and Quit");
			int inp = Integer.parseInt(InputUtil.getString());
			switch(inp) {
			case 1: {
				CliniqueManagement.addDoctor();
				break;
			}
			case 2: {
				CliniqueManagement.addPatient();
				break;
			}
			case 3: {
				CliniqueManagement.searchD();
				break;
			}
			case 4: {
				CliniqueManagement.searchP();
				break;
			}
			case 5: {
				System.out.print("Give the Name of The doctor to Take appointment from: ");
				String dName = InputUtil.getString();
				System.out.print("Give the Name of The patient: ");
				String pName = InputUtil.getString();
				CliniqueManagement.takeAppointment(dName, pName);
				break;
			}
			case 6: {
				System.out.print("Give the Name of The doctor: ");
				String dName = InputUtil.getString();
				CliniqueManagement.printeReport(dName);
				break;
			}
			case 7: {
				CliniqueManagement.saveAndQuit();
				break;
			}
		}
			if(inp == 7) break;
		}
	}

}
