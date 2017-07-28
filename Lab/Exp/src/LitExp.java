
public class LitExp extends Exp {
	
	int value;
	
	public LitExp(int a){
		value = a;
	}

	public String show() {
		return "" + value;
	}

	public int evaculate(Form form) {
		return value;
	}

}
