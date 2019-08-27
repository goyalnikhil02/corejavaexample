package com.example.java8;

import java.util.Scanner;
import java.util.function.Predicate;
class User {
	String username;
	String password;

	public User(String username, String password) {
		//super();
		this.username = username;
		this.password = password;
	}

}
public class PredicateauthExample {
	

	public static void main(String[] args) {
		Predicate<User> authenticate = user -> user.username.equals("Nikhil") && user.password.equals("Goyal");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String username=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		
		User userdata=new User(username,pass);
		
		if(authenticate.test(userdata))
		{
			System.out.println("Done");
		}
		else
		{
			System.out.println("Wrong");
		}

	}

}
