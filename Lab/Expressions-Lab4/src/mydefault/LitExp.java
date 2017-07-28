package mydefault;

public class LitExp extends VarandLit{
	int a;
	
	public LitExp(int b){
		a = b;
	}
	

	public String show() {
		// TODO Auto-generated method stub
		return ""+ a;
	}


	public int evaculate(Mappings m) {
		// TODO Auto-generated method stub
		return a;
	}


	@Override
	public Expression simplify(Mappings m) {
		// TODO Auto-generated method stub
		return lit(a);
	}


	@Override
	public String treeshow() {
		// TODO Auto-generated method stub
		return Integer.toString(a);
		
	}



}
