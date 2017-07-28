package mydefault;

public class VarExp extends VarandLit{
    
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
	public Expression simplify(Mappings m) {
		// TODO Auto-generated method stub
		try{
			int t = m.get(name);
			return lit(t);
			
		}catch(Exception e){
			return var(name);
		}
	}

	@Override
	public String treeshow() {
		// TODO Auto-generated method stub
		return name;
	}


}
