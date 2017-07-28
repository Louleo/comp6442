package mydefault;

public abstract class OperatorCal extends Expression {
	
	Expression left;
	Expression right;
	
	public abstract String show();


	public abstract int evaculate(Mappings m);

	public int size() {
		// TODO Auto-generated method stub
		return 1 +left.size()+right.size();
	}

	
	public int height() {
		// TODO Auto-generated method stub
		return 1 + Math.max(left.height(), right.height());
	}


	public int operators() {
		// TODO Auto-generated method stub
		return 1+left.operators()+right.operators();
	}
	
	
	public abstract Expression simplify(Mappings m);
	

}