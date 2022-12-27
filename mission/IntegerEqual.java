
public class IntegerEqual {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		if(a == b)	System.out.println("a == b");
		else		System.out.println("a != b");

		System.out.println("==================================================");

		System.out.println("new Integer()");
		
		Integer a1 = new Integer(1);
		Integer b1 = new Integer(1);

		System.out.println("a1.hashCode : " + a1.hashCode());
		System.out.println("b1.hashCode : " + b1.hashCode());
		
		if(a1 == b1)		System.out.println("== : a1 == b1");
		else				System.out.println("== : a1 != b1");

		if(a1.equals(b1))	System.out.println("equals : a1 == b1");
		else				System.out.println("equals : a1 != b1");

		System.out.println("==================================================");

		System.out.println("Integer.valueOf()");
		
		Integer a2 = Integer.valueOf(1);
		Integer b2 = Integer.valueOf(1);

		System.out.println("a2.hashCode : " + a2.hashCode());
		System.out.println("b2.hashCode : " + b2.hashCode());

		if(a2 == b2)		System.out.println("== : a2 == b2");
		else				System.out.println("== : a2 != b2");

		if(a2.equals(b2))	System.out.println("equals : a2 == b2");
		else				System.out.println("equals : a2 != b2");
		
		b2 = 2;
		
		System.out.println("b2.hashCode : " + b2.hashCode());
		
		if(a2 == b2)		System.out.println("== : a2 == b2");
		else				System.out.println("== : a2 != b2");

		if(a2.equals(b2))	System.out.println("equals : a2 == b2");
		else				System.out.println("equals : a2 != b2");
		
	}

}
