package edu.pnu.fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackInputStreamTest {

	public static void main(String[] args) {
		
		try {
			PushbackInputStream pis = new PushbackInputStream(new FileInputStream("text.txt"), 2);
			
			byte[] buf = new byte[2];
			int rd = pis.read(buf);
			
			String str1 = new String(buf);
			System.out.println("str1:" + str1);
			
			pis.unread(buf);

			String str2 = new String(buf);
			System.out.println("str2:" + str2);

			rd = pis.read(buf);
			
			String str3 = new String(buf);
			System.out.println("str3:" + str3);

			pis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
