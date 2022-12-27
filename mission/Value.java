
public class Value {
	private int val;

	public Value() {
	}
	
	public Value(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.val == ((Value)obj).getVal();
	}
}
