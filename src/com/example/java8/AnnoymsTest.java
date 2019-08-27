package com.example.java8;

public class AnnoymsTest {
	public static void main(String[] args) {
		Runnable r =new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5;i++)
				{
					System.out.println("In:"+i);
				}
				
			}
		};
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<5;i++)
		{
			System.out.println("Main"+i);
		}
		
	}

}
