package com.example.java8.map;

import java.util.function.Predicate;

public class EmployeeFilter {
	
	public static boolean isGoodEmp(Employee employee)
	{
		return employee.getCity().equals("NOIDA") && (employee.getSyalary() >=100 &&  employee.getSyalary()<1000);
	}
	
	public static Predicate<Employee> employeesSalCity()
	{
		return employee -> employee.getCity().equals("NOIDA") && (employee.getSyalary() >100 &&  employee.getSyalary()<1000);
	}
	
	
}
