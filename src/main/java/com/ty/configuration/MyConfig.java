package com.ty.configuration;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ty.helper.Dependency;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class MyConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public Dependency scannerDependency() {
		return new Dependency(scanner());
	}
	@Bean
	public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("vikas").createEntityManager();
	
	}
	@Bean
	public EntityTransaction entityTransaction() {
        return entityManager().getTransaction();
	
	}

}
