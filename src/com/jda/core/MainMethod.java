package com.jda.core;

import java.io.IOException;
import com.jda.util.InputUtil;
import com.jda.util.Manager;

public class MainMethod {

	private static Manager m1 = new Manager();
	private static String path = "/home/bridgelabz/workspace/OOPS/src/com/jda/util/AdressFolder/";
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		while(true){
			System.out.println("1. Create A New File");
			System.out.println("2. Open Existing File");
			System.out.println("3. Save");
			System.out.println("4. SaveAs");
			System.out.println("5. Close");
			System.out.println("6. Quit");
			int i = Integer.parseInt(InputUtil.getString());
			switch(i){
			case 1: {
				System.out.print("Filename: ");
				m1.createAddBook(path + InputUtil.getString() + ".json");
				break;
			}
			case 2: {
				System.out.print("Filename: ");
				m1.openAB(path + InputUtil.getString() + ".json");
				break;
			}
			case 3: {
				System.out.print("Filename: ");
				m1.save(m1.openFile(path + InputUtil.getString() + ".json"));
				break;
			}
			case 4: {
				System.out.print(" Enter FilenameFrom and Enter FileTo ");
				m1.saveAs(path + InputUtil.getString() + ".json", path + InputUtil.getString() + ".json");
				break;
			}
			case 5: {
				System.out.print("Filename: ");
				m1.save(m1.openFile(path + InputUtil.getString() + ".json"));
				break;
			}
			}
			if(i == 6 || i == 5)
				break;
			m1.listOfAB();
		}
	}
}
