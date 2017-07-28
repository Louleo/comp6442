
public class AddExp extends Exp {
    Exp left,right;
    
    public AddExp(Exp l, Exp r){
    	left = l;
    	right = r;
    }
	@Override
	public String show() {
		// TODO Auto-generated method stub
		return "(" + left.show() + "+" + right.show() + ")";
	}

	@Override
	public int evaculate(Form form) {
		// TODO Auto-generated method stub
		return left.evaculate(form) + right.evaculate(form);
	}

}
