package edu.pnu.exception;

public class DivideByZeroException extends Exception {
	private static final long serialVersionUID = 1L;

	public DivideByZeroException() {
		super("0으로 나누면 안되요!!!");
	}
}
