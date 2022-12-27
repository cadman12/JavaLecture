import java.util.Scanner;

public class BillCounter {

	public static void main(String[] args) {

		int money;
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("금액 입력 : ");
			while(0 < (money = sc.nextInt())) {
			
				int tmoney = (money / 1000) * 1000;

				System.out.println("절사 금액 : " + (money - tmoney));
				System.out.println("계산 금액 : " + tmoney);
				System.out.println("-".repeat(25));

				int[] array = { 50000, 10000, 5000, 1000 };

				for (int t : array) {
					int c = tmoney/t;
					if (0 < c)
						System.out.printf("%5d원 * %d장 = %d원\n", t, c, t*c);
					else
						System.out.printf("%5d원\n", t);
					
					tmoney -= (t * c);
				}
				System.out.println("-".repeat(25));
				System.out.print("금액 입력 : ");
			}
		}
		
		System.out.println("Good Bye!!!");
	}	
}
