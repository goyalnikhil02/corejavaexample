package com.example.java8.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
	
	public static void main(String[] args) {
		
		stringToLowerCase();
	    seperateEvenODDNumbers();
	    filterEmployee();
	    
	}
	

	private static void filterEmployee() {
		
		
		Employee emp1=new Employee(100, "NOIDA");
		Employee emp2=new Employee(90,  "NOIDA");
		Employee emp3=new Employee(120, "NOIDA");
		Employee emp4=new Employee(120, "NOIDA");
		Employee emp5=new Employee(120, "GURGAON");
		
		
		List<Employee> emplList=Arrays.asList(emp1,emp2,emp3,emp4,emp5);

		List<Employee> data=emplList.stream().filter(EmployeeFilter ::isGoodEmp).collect(Collectors.toList());
		
		System.out.println(data+">>>>>>>>>>>>>>>>");
		
		emplList.stream().filter(EmployeeFilter ::isGoodEmp).collect(Collectors.toList()).forEach(System.out::println);
		
		
		
		
		
	}


	private static void seperateEvenODDNumbers() {
		List<Integer> numberList=Arrays.asList(1,2,4,7,6,9,11,98);
		
		List<Integer> datalist=numberList.stream().map(no -> (no +100)).filter(value -> value%2==0).collect(Collectors.toList());
		System.out.println(datalist);
		
		
		
		
		
	}

	private static void stringToLowerCase() {
	
		List<String> list=Arrays.asList("NIKHIL","GOYAl","GOEL");
		
		
		List<String> collectedList=list.stream().map(String::toLowerCase).collect(Collectors.toList());
		System.out.println(collectedList);
	}

}
