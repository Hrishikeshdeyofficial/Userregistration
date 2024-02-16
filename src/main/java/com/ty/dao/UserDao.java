package com.ty.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.configuration.MyConfig;
import com.ty.entity.UserInfo;
import com.ty.helper.Dependency;

public class UserDao {

	static Scanner input = Dependency.scanner;
	private static ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	
	private static EntityManager manager = (EntityManager) context.getBean("entityManager");
	private static EntityTransaction transaction = (EntityTransaction)context.getBean("entityTransaction");
	
	
	
	
	
	
	public static void saveUser(UserInfo user)
	{
		System.out.println("Enter user name: ");
		user.setUserName(input.next());
		
		System.out.println("Enter password: ");
		user.setUserPasword(input.next());
		
		System.out.println("Enter email: ");
		user.setUserEmail(input.next());
		
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		
		System.out.println("User saved Successfully!!");
	}
	
	public static List<UserInfo> findUser(String userName, String password)
	{
		String query_statement = "SELECT u FROM UserInfo u WHERE u.userName = ?1 AND u.userPasword = ?2";
		Query query =manager.createQuery(query_statement);
		
		query.setParameter(1, userName);
		query.setParameter(2, password);
		
		List<UserInfo> userLists = query.getResultList();
		
		if(userLists != null)
		{
		for(UserInfo users : userLists)
		{
			System.out.println("User Name: " + users.getUserName());
			System.out.println("User Email: " + users.getUserEmail());
		}
		}
		else {
			System.out.println("No user found");
		}
		
		return userLists;
		
	}
	
	public static void updateUser(String userName, String userPassword)
	{
		List<UserInfo> userLists = UserDao.findUser(userName, userPassword);
		for(UserInfo users: userLists)
		{
		System.out.println("Enter the userName: ");
		users.setUserName(input.next());
		
		System.out.println("Enter the user Email: ");
		users.setUserEmail(input.next());
		
		System.out.println("Enter the user Password: ");
		users.setUserPasword(input.next());
		
		transaction.begin();
		manager.merge(users);
		transaction.commit();
		}
		
		
		
		System.out.println("Data updated");
	}
	
	public static void removeUser(String userName, String userPassword)
	{
		List<UserInfo> userLists = UserDao.findUser(userName, userPassword);
		for(UserInfo users: userLists)
		{
		
		
		transaction.begin();
		manager.remove(users);
		transaction.commit();
		}
		System.out.println("Removed successfully");
	}
}
