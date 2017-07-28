package mydefault;

public class SubtExp extends OperatorCal{

	public SubtExp(Expression l, Expression r){
		super();
		left = l;
		right = r;
	}

	@Override
	public String show() {
		// TODO Auto-generated method stub
		return "(" + left.show() + "-" + right.show() + ")";
	}

	@Override
	public int evaculate(Mappings m) {
		// TODO Auto-generated method stub
		return left.evaculate(m) - right.evaculate(m);
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
			return lit(leftvalue - rightvalue);
		}else if(i ==1 && j==2){
			return subt(lit(leftvalue),right);
		}else if(i==2 && j==1){
			return subt(left,lit(rightvalue));
		}else{
			return subt(left,right);
		}
	}


}
