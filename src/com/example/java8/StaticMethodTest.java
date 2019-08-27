package com.example.java8;

interface RUN{
	public static void run()
	{
		System.out.println("Running");
	}
}
public class StaticMethodTest implements RUN{
	
	public static void run()
	{
		System.out.println("Waliking");
	}
	public static void main(String[] args) {
		//not necessar to overide the statci method of interface.
		
		//StaticInInterface.
		RUN.run();
		
		StaticMethodTest.run();

	}

}
