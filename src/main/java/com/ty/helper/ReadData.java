package com.ty.helper;

public class ReadData {

	public static String getUserName()
	{
		System.out.println("Enter the user name: ");
		return Dependency.scanner.next();
		
	}
	
	public static String getUserPassword()
	{
		System.out.println("Enter the user password: ");
		return Dependency.scanner.next();
		
	}
}
