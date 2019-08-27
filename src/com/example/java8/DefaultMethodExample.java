package com.example.java8;

interface UP{
	
	static  void run1() {
		System.out.println();
	};
	
	/* public default void run()
	{
		System.out.println("Running in UP");
	}*/
}

interface DOWM
{
	
	default public void run()
	{
		System.out.println("Running in DOWN");
	}
}

public class DefaultMethodExample implements UP,DOWM{

	public static void main(String[] args) {
     DefaultMethodExample obj=new DefaultMethodExample();
     obj.run();
		
		
	}

	@Override
	public void run() {
		System.out.println("MY own RUn");
		//DOWM.super.run();
		
	}

}
