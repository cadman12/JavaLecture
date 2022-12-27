public class BinString {

	public static void main(String[] args) {

		byte [] b = { 127, 3, 2, 1, 0, -1, -2, -3, -127, -128 };

		int t1 = 0b11;
		int t2 = 011;
		int t3 = 0x11;
		
		for (int i = 0 ; i < b.length ; i++ ) {
			
			String s = Integer.toBinaryString(b[i]);
			if (8 < s.length()) s = s.substring(s.length()-8);
			System.out.printf("b%d\t%d\t%08d\n", i,  b[i], Integer.parseInt(s));
		}
	}
}

