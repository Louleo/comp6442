
public class VarExp extends Exp {
	
	String name;
	
	
	public VarExp(String n){
		name = n;
	}

	public String show() {
		return "" + name;
	}

	public int evaculate(Form form) {
		return form.get(name);
	}

}
