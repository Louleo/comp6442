package mydefault;

public class DivdExp extends OperatorCal{

	public DivdExp(Expression l, Expression r){
		left = l;
		right = r;
	}


	public String show() {
		// TODO Auto-generated method stub
		return "(" + left.show() + "/" + right.show() + ")";
	}


	public int evaculate(Mappings m) {
		// TODO Auto-generated method stub
		return left.evaculate(m) / right.evaculate(m);
	}



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
			return lit(leftvalue / rightvalue);
		}else if(i ==1 && j==2){
			return div(lit(leftvalue),right);
		}else if(i==2 && j==1){
			return div(left,lit(rightvalue));
		}else{
			return div(left,right);
		}
	}



}
