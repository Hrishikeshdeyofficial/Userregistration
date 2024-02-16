package com.ty.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.configuration.MyConfig;
import com.ty.dao.UserDao;
import com.ty.entity.UserInfo;
import com.ty.helper.Dependency;
import com.ty.helper.ReadData;

public class Controller {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		UserInfo user = (UserInfo)context.getBean("user");
		
		while(true)
		{
		System.out.println("WELCOME!!");
		System.out.println("1.SAVE USER \n2.FIND USER \n3.UPDATE USER \n4.REMOVE USER");
		System.out.println("Enter your choice: ");
		int choice = Dependency.scanner.nextInt();
		switch(choice)
		{
		case 1: UserDao.saveUser(user);
				break;
		
		case 2:UserDao.findUser(ReadData.getUserName(), ReadData.getUserPassword());
				break;
		case 3:UserDao.updateUser(ReadData.getUserName(), ReadData.getUserPassword());
				break;
		case 4:UserDao.removeUser(ReadData.getUserName(), ReadData.getUserPassword());
				break;
		case 5: System.out.println("Thank You");
				System.exit(0);
		}
		}
		
	}
}
