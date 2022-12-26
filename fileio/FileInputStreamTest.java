package edu.pnu.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileInputStreamTest {

	PrintStream nl;
	
	public static long test01() {
		
		long start = System.currentTimeMillis();
		try (InputStream is = new FileInputStream("test.dat");) {
			int ch;
			while(0 <= (ch = is.read())) {
//				System.out.println(ch);
			}		
			is.close();
			
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test02() {
	
		byte[] buffer = new byte[1024];

		long start = System.currentTimeMillis();
		try (InputStream is = new FileInputStream("test.dat");) {
			while(0 <= is.read(buffer)) {
//				System.out.println(new String(buffer));
			}
			is.close();

			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test03() {
		
		byte[] buffer = new byte[1024];

		long start = System.currentTimeMillis();
		try (InputStream is = new FileInputStream("test.dat");
				InputStream bis = new BufferedInputStream(is);) {
			while(0 <= bis.read(buffer)) {
//				System.out.println(new String(buffer));
			}
			
			// 1차 스트림을 이용해 2차 스트림을 만든 경우 2차 스트림만 close 해주면 된다.			
			bis.close();

			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test04() {
		
		long start = System.currentTimeMillis();
		try (Reader fr = new FileReader("test.dat");) {
			int ch;
			while(0 <= (ch = fr.read())) {
//				System.out.println(new String(buffer));
			}
			fr.close();

			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return -1L;
	}
	
	public static long test05() {
		
		char[] buffer = new char[1024];

		long start = System.currentTimeMillis();
		try (Reader fr = new FileReader("test.dat");) {
			while(0 <= fr.read(buffer)) {
//				System.out.println(buffer.toString());
			}
			fr.close();

			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}	
	
	public static long test06() {
		
		char[] buffer = new char[1024];

		long start = System.currentTimeMillis();
		try (Reader fr = new FileReader("test.dat");
				Reader br = new BufferedReader(fr);) {
			while(0 <= br.read(buffer)) {
//				System.out.println(buffer.toString());
			}
			br.close();

			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}		
	
	public static long test07() {

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		long start = System.currentTimeMillis();
		try (RandomAccessFile raf = new RandomAccessFile("test.dat", "r");
				FileChannel channel = raf.getChannel();) {
			int len;
			while((len = channel.read(buffer)) > 0) {
//				System.out.println("-->" + len + ":" + new String(buffer.array(), 0, len, "UTF-8"));
				buffer.clear();
			}
			
			channel.close();
			
			return System.currentTimeMillis() - start;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1L;
	}
	
	public static void main(String[] args) {

		System.out.println("-->test01");
		long t1 = test01();	// 1byte씩 읽어서 출력
		System.out.println("-->test02");
		long t2 = test02();	// 1024byte 버퍼를 생성해서 출력
		System.out.println("-->test03");
		long t3 = test03();
		System.out.println("-->test04");
		long t4 = test04();
		System.out.println("-->test05");
		long t5 = test05();
		System.out.println("-->test06");
		long t6 = test06();
		System.out.println("-->test07");
		long t7 = test07();

		System.out.printf("test01():FileInputStream:1byte :%dms\n", t1);
		System.out.printf("test02():FileInputStream:buffer:%dms\n", t2);
		System.out.printf("test03():BufferedInputStream   :%dms\n", t3);
		System.out.printf("test04():FileReader:1byte      :%dms\n", t4);
		System.out.printf("test05():FileReader:buffer     :%dms\n", t5);
		System.out.printf("test06():BuffredReader         :%dms\n", t6);
		System.out.printf("test07():FileChannel           :%dms\n", t7);

		System.out.println("Done");
	}
}
