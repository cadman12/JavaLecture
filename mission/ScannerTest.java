import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	private static void test01() {
		try (Scanner sc = new Scanner(new File("myNumbers"))) {
			while (sc.hasNextLong()) {
				long aLong = sc.nextLong();
				System.out.println("aLong:" + aLong);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void test02() {
		String input = "1 fish 2 fish red fish blue fish";
		Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
		System.out.println(s.nextInt());
		System.out.println(s.nextInt());
		System.out.println(s.next());
		System.out.println(s.next());
		s.close();
	}	
	
	private static void test03() {
		Scanner s = new Scanner(System.in);

		try {
			System.out.print("val:");
			int i = s.nextInt();
			
			System.out.println("int:" + i);
		} catch (Exception e) {
			System.out.println("not integer");
			e.printStackTrace();
		} finally {
			s.close();
		}
	}
	
	public static void main(String[] args) {
		//test01();
		//test02();
		test03();
	}
}
