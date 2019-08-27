package com.example.java8;

import java.util.function.Predicate;

public class Predicate2Example {


	public static void main(String[] args) {
		String[] name= {null,"Nikhil","",null,"Nehra","akhil","Neha","Nitin"};
		Predicate<String> startwithN=s-> s!=null && !s.isEmpty() && s.startsWith("N");

		for(String s:name)			
		{
			if(startwithN.test(s))
			{
				System.out.println(s);
			}
		}
	}

}
