package edu.pnu.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TextFileTest {

	public void writeTextFile01() {
		try (FileWriter fw = new FileWriter("text.txt");) {

			fw.write("abcd\n");
			fw.write("1234\n");
			
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeTextFile02() {
		try (FileWriter fw = new FileWriter("text.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);) {

			bw.write("ijkl\n");
			bw.write("9012\n");
			
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void writeTextFile03() {
		try (FileOutputStream fw = new FileOutputStream("text.txt", true);
			PrintWriter ps = new PrintWriter(fw);) {

			ps.println("efgh");
			ps.println("5678");
			
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readTextFile01() {
		try (FileReader fr = new FileReader("text.txt");
				BufferedReader br = new BufferedReader(fr);) {

			String str;
			while((str = br.readLine()) != null)
				System.out.println(str);
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {

		TextFileTest tt = new TextFileTest();
		
		tt.writeTextFile01();
		tt.writeTextFile02();
		tt.writeTextFile03();
		System.out.println("-".repeat(30));
		tt.readTextFile01();

		System.out.println("Done");
	}
}
