package mydefault;

public class SimpleFactory {
	static Expression createAdd(Expression l, Expression r) {
		return new AddExp(l, r);
	}
	static Expression createLit(int b) {
		return new LitExp(b);
	}
	static Expression createMulti(Expression l, Expression r) {
		return new MultiExp(l, r);
	}
	static Expression createSubt(Expression l, Expression r) {
		return new SubtExp(l, r);
	}
	static Expression createDivd(Expression l, Expression r) {
		return new DivdExp(l, r);
	}
	static Expression createVar(String b) {
		return new VarExp(b);
	}
	
}
