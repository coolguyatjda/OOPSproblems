package com.jda.util;

import java.util.Scanner;

public class InputUtil {
	static Scanner in = new Scanner(System.in);
   private InputUtil() {
		// TODO Auto-generated constructor stub
	}
	public static String getString(){
		return in.nextLine();
	}
	public static int getInt(){
		return in.nextInt();
	}
	public static long getLong(){
		return in.nextLong();
	}
}
