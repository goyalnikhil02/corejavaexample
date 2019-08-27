package com.example.java8;

public class LambdaTest {

	public static void main(String[] args) {
		/*Runnable r=()->{
			for(int i=0;i<5;i++)
			{
				System.out.println("New :"+i);
			}
		};*/
		Thread t=new Thread(()->{
			for(int i=0;i<5;i++)
			{
				System.out.println("New :"+i);
			}
		});
		t.start();
		for(int i=0;i<5;i++)
		{
			System.out.println("Main :"+i);
		}
	}

}
