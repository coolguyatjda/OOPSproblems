package com.jda.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

import com.jda.util.InputUtil;

public class RegexProb {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.print("Give Your Full Name: ");
		String fullName = InputUtil.getString();
		System.out.print("Give Your Phone Number: ");
		String phoneNumber = InputUtil.getString();
		File file = new File("/home/bridgelabz/workspace/OOPS/src/com/jda/util/Regex.txt");
		Scanner sc = new Scanner(file);
		String inpstr = sc.nextLine();
		
		inpstr =  replace(inpstr, "<<\\w+>>",  fullName.split(" ")[0]);
		inpstr =  replace(inpstr, "<<\\w+\\s\\w+>>",  fullName);
		inpstr =  replace(inpstr, "x{10}",  phoneNumber);
		inpstr =  replace(inpstr, "x{2}/x{2}/x{4}",  new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
//		inpstr = replace(inpstr, fullName, "<{2}//w+//s+//w{2}>");
//		inpstr = replace(inpstr, phoneNumber, "x{10}");
//		inpstr= replace(inpstr, new SimpleDateFormat("dd/MM/yyyy").format(new Date()), "xx/xx/xxxx");
		System.out.print(inpstr);

	}
	public static String replace(String inpstr, String regex, String replace){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inpstr);
		if(m.find())
				inpstr = m.replaceAll(replace);
		return inpstr;
	}
}
