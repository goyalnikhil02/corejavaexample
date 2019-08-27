package com.example.java8.map;

public class Employee {

	int syalary;
	String city;

	public Employee(int syalary, String city) {
		super();
		this.syalary = syalary;
		this.city = city;
	}

	public int getSyalary() {
		return syalary;
	}

	public void setSyalary(int syalary) {
		this.syalary = syalary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [syalary=" + syalary + ", city=" + city + "]";
	}

	
}
