package mydefault;

public class AddExp extends Expression{
	Expression left;
	Expression right;
	public AddExp(Expression l, Expression r){
		super();
		left = l;
		right = r;
	}

	@Override
	public String show() {
		// TODO Auto-generated method stub
		return "(" + left.show() + "+" + right.show() + ")";
	}

	@Override
	public int evaculate(Mappings m) {
		// TODO Auto-generated method stub
		return left.evaculate(m) + right.evaculate(m);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 1 +left.size()+right.size();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 1 + Math.max(left.height(), right.height());
	}

	@Override
	public int operators() {
		// TODO Auto-generated method stub
		return 1+left.operators()+right.operators();
	}

	@Override
	public Expression simplify(Mappings m) {
		// TODO Auto-generated method stub
		int leftvalue = 0;
		int rightvalue = 0;
		int i = 0;
		int j = 0;
		try{
		    leftvalue = left.evaculate(m);
		    i = 1;
		}catch(Exception e){
			i = 2;
		}
		try{
			rightvalue = right.evaculate(m);
			j = 1;
		}catch(Exception e){
			j = 2;
		}
		if (i ==1 && j ==1){
			return lit(leftvalue + rightvalue);
		}else if(i ==1 && j==2){
			return add(lit(leftvalue),right);
		}else if(i==2 && j==1){
			return add(left,lit(rightvalue));
		}else{
			return add(left,right);
		}
		
	}

}
