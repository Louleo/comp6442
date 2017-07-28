package mydefault;
import static mydefault.Expression.*;

public class DemoExpression {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mappings m = new Mappings();
		m.put("x", 5);
		Expression e1 = add(mult(lit(2),lit(3)), div(var("y"),var("x")));
		Expression e6 = e1.simplify(m);
		System.out.println(e6.show());
		Expression e2 = mult(lit(2),add(lit(3),var("x")));
		System.out.println(e2.show() + "=" +e2.evaculate(m) );
		System.out.println(e2.size());
		System.out.println(e2.height());
		System.out.println(e2.operators());
		Expression e3 = div(lit(4),lit(2));
		System.out.println(e3.show() + "=" +e3.evaculate(m) );
		Expression e4 = subt(lit(5),lit(1));
		System.out.println(e4.show() + "=" +e4.evaculate(m) );
		Expression e5 = mult(lit(2),subt(lit(7),lit(5)));
		System.out.println(e5.show() + "=" +(e5.simplify(m)).show() );
		
		
	}

}
