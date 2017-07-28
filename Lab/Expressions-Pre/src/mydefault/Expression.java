package mydefault;

public abstract class Expression {

		public static Expression add(Expression l, Expression r){
			return  SimpleFactory.createAdd(l, r);
		}
		public static Expression lit(int b){
			return SimpleFactory.createLit(b);
		}
		public static Expression mult(Expression l, Expression r){
			return  SimpleFactory.createMulti(l, r);
		}
		public static Expression subt(Expression l, Expression r){
			return  SimpleFactory.createSubt(l, r);
		}
		public static Expression div(Expression l, Expression r){
			return  SimpleFactory.createDivd(l, r);
		}
		public static Expression var(String b){
			return SimpleFactory.createVar(b);
		}
		public abstract String show();
		
		public abstract int evaculate(Mappings m);
		
		public abstract int size();
		
		public abstract int height();
		
		public abstract int operators();
		
		public abstract Expression simplify(Mappings m);
		
}
