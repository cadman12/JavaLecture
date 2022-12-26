package edu.pnu.exception;

import java.util.Scanner;

public class ExceptionTest {

	public int divide(int a, int b) {
		int ret = 0;
		try {
			ret = a/b;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int divide2(int a, int b) throws Exception {
		return a/b;
	}

	public int divide3(int a, int b) throws DivideByZeroException {
		int ret = 0;
		
		if (b == 0)
			throw new DivideByZeroException();
			
		ret = a/b;
		
		return ret;
	}
	
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.printf("a:");
			int a = sc.nextInt();
			System.out.printf("b:");
			int b = sc.nextInt();
			
			ExceptionTest et = new ExceptionTest();
			int res = 0;
			try {
				res = et.divide3(a, b);
			} catch (Exception e) {
				if (e instanceof ArithmeticException)
					System.out.println("divide zero");
				else
					e.printStackTrace();
			}
			System.out.println("result:" + res);
		}
	}

}
