package edu.pnu.interfacetest;

public class Second {

	public static void main(String[] args) {
		TestInterface ti = new TestClass();
		
		System.out.println("인터페이스 구현 객체 생성 : " + ti.sum(10, 20));
		
		System.out.println("익명 클래스 구현 : " + (new TestInterface() {
			public int sum(int a, int b) {
				return a*10 + b*10;
			}
		}).sum(10, 20));
	}
}
