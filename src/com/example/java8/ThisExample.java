package com.example.java8;

interface test{
	public void m1();
}
public class ThisExample {
int x=10;

public void m2()
{
	test t=new test()
			{
int x=20;
				@Override
				public void m1() {
		System.out.println(this.x);// refer to current  obj here it is Inner class THis is instanance variable
					System.out.println(ThisExample.this.x);
				}
		
			};
			
			t.m1();
}
	public static void main(String[] args) {
		
		ThisExample tobj=new ThisExample();
		tobj.m2();
				
	}

}
