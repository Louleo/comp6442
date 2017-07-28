package mydefault;

public class VarExp extends Expression{
    
	String name;
	
	public VarExp(String n){
		name = n;
	}

	public String show() {
		return "" + name;
	}

	public int evaculate(Mappings m) {
		return m.get(name);
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
		try{
			int t = m.get(name);
			return lit(t);
			
		}catch(Exception e){
			return var(name);
		}
	}

}
