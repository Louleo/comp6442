package mydefault;

public class LitExp extends Expression{
	int a;
	
	public LitExp(int b){
		a = b;
	}
	
	@Override
	public String show() {
		// TODO Auto-generated method stub
		return ""+ a;
	}

	@Override
	public int evaculate(Mappings m) {
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int operators() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Expression simplify(Mappings m) {
		// TODO Auto-generated method stub
		return lit(a);
	}


}
