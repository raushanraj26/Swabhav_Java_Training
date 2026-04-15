package com.monocept.EcxeptionHandling;

public class ExceptionDemo {
	public static void main(String[] args) {
		System.out.println("1");
		a();
		System.out.println("2");
	}

	private static void a() {
		// TODO Auto-generated method stub
		try {
			System.out.println("3");
			b();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		System.out.println("4");
	}

	private static void b() throws Exception {
		// TODO Auto-generated method stub
//		int x=10/0;
		System.out.println("5");
		throw new Exception("Exception occur");
		//System.out.println("6"); -->unreachable code
	}

}

// try {
//		System.out.println(10/0);
//		//throw new ArithmeticException();
//	}catch(Exception e) {
//		System.out.println(e.getMessage());
//	}
