public class FreeFall {

	final double g = 9.81;
	
	double zpos;
	int second;

	private double getNextPosition() throws MinusSecondException {

		if (second < 0)
			throw new MinusSecondException("경과시간이 0보다 작습니다.");
		
		return (zpos - g*second*second/2.0);
	}	
	
	public static void main(String[] args)  {
	
		// 초기 위치
		double initZ = 1000.0;
		
		// 경과 시간
		int sec = -5;

		// 위치 구하기 객체 생성
		FreeFall ff = new FreeFall();
		
		// 변수값 설정
		ff.setZpos(initZ);
		ff.setSecond(sec);
		
		try {
			System.out.printf("초기에 상공 %d미터에서 자유낙하하는 물체의 %d초 후 위치는 상공 %.2f미터입니다.\n",
					(int)initZ, sec, ff.getNextPosition());
		} catch (MinusSecondException e) {
			System.out.println(e.getMessage());
		}
	}

	// 변수값 설정을 위한 Setter
	public void setZpos(double zpos) {
		this.zpos = zpos;
	}
	public void setSecond(int second) {
		this.second = second;
	}
}

class MinusSecondException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MinusSecondException() {
		super("경과시간은 0보다 큰 양의 정수이어야 합니다.");
	}
	
	public MinusSecondException(String str) {
		super(str);
	}
}