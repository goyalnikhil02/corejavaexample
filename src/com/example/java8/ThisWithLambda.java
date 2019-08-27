package com.example.java8;

interface test1 {
	public void m1();
}

public class ThisWithLambda {
	int x = 10;

	public void m2() {
		test1 t = () -> {
			int x = 20;//this is local varibale not instance variable
			System.out.println("Now:"+this.x);// refer to current obj here it is Inner class THis is instanance variable
			
		};

		t.m1();
	}

	public static void main(String[] args) {

		ThisWithLambda tobj = new ThisWithLambda();
		tobj.m2();

	}

}
