package edu.pnu.interfacetest;

public interface TestInterface {
	public default int sum(int a, int b) {
		return a+b;
	}
}
