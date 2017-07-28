package mydefault;

public abstract class VarandLit extends Expression {

	public abstract String show();


	public abstract int evaculate(Mappings m);

	public int size() {
		// TODO Auto-generated method stub
		return 1;
	}

	public int height() {
		// TODO Auto-generated method stub
		return 1;
	}


	public int operators() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public abstract String treeshow();

	public abstract Expression simplify(Mappings m);

}