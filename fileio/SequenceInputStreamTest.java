package edu.pnu.fileio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamTest {

	// SequenceInputStream(Enumeration e) 예제
	public static void test01() {
		byte[] barr1 = {1,2,3};
		byte[] barr2 = {4,5,6};
		byte[] barr3 = {7,8,9};
		
		byte[] output = null;
		
		ByteArrayInputStream bis1 = new ByteArrayInputStream(barr1);
		ByteArrayInputStream bis2 = new ByteArrayInputStream(barr2);
		ByteArrayInputStream bis3 = new ByteArrayInputStream(barr3);
		
		Vector<ByteArrayInputStream> v = new Vector<>();
		v.add(bis1);
		v.add(bis2);
		v.add(bis3);
		
		SequenceInputStream sis = new SequenceInputStream(v.elements());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int data = 0;
		try {
			while((data = sis.read()) != -1) {
				bos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		output = bos.toByteArray();
		System.out.println(Arrays.toString(output));
	}

	//SequenceInputStream(InputStream s1, InputStream s2) 예제
	public static void test02() {
		byte[] barr1 = {1,2,3};
		byte[] barr2 = {4,5,6};
		
		byte[] output = null;
		
		ByteArrayInputStream bis1 = new ByteArrayInputStream(barr1);
		ByteArrayInputStream bis2 = new ByteArrayInputStream(barr2);
		
		SequenceInputStream sis = new SequenceInputStream(bis1, bis2);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int data = 0;
		try {
			while((data = sis.read()) != -1) {
				bos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		output = bos.toByteArray();
		System.out.println(Arrays.toString(output));
	}
	
	public static void main(String[] args) {

		test01();
		test02();
	}

}
