package com.example.java8;

import java.util.function.Predicate;

interface Pr{
	boolean testing(int i);
}
public class Predicate1 {

	public static void main(String[] args) {
    /* Pr a= (int i) -> i>10;
     System.out.println(a.testing(12));*/
		
	Predicate<String> p1 =i->i.equals("Nikhil");
	
	Predicate<String> p2 =i->i.length()>6;
	
	System.out.println(p1.test("Nikhil"));
	}

}
