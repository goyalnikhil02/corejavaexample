package com.example.java8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

	public static void main(String[] args) {
		String userName = System.getProperty("user.name");
		System.out.println("Window's Username: "+userName);
		
		List<Integer> al= new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		List<Integer> alnew=al.stream().map(i ->(i *2)).collect(Collectors.toList());
		System.out.println(alnew);
		System.out.println(al.stream().map(i ->(i *2)).count());
	}
}
