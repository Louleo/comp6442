package mydefault;

public interface Operator {
	public String show();
	
	public int evaculate(Mappings m);
	
	public abstract int size();
	
	public abstract int height();
	
	public abstract int operators();
	
	public abstract Expression simplify(Mappings m);
}
