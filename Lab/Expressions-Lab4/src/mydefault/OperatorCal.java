package mydefault;

public abstract class OperatorCal extends Expression {
	
	Expression left;
	Expression right;
	
	public abstract String show();


	public abstract int evaculate(Mappings m);

	public int size() {
		// TODO Auto-generated method stub
		return 1 +left.size()+right.size();
	}

	
	public int height() {
		// TODO Auto-generated method stub
		return 1 + Math.max(left.height(), right.height());
	}


	public int operators() {
		// TODO Auto-generated method stub
		return 1+left.operators()+right.operators();
	}
	
	
	public abstract Expression simplify(Mappings m);
	
	public String treeshow(){
		String data = ;
		String stl = left.treeshow(); 		
		String str = right.treeshow();
		String stal[] = stl.split("\n"); 		
		String star[] = str.split("\n");
		int lenl = stal[0].length();
		int lenr = star[0].length();
		StringBuffer res = new StringBuffer();
		String strdata = data + "";
		int fullsize = lenl + strdata.length() + lenr; 
		res.append(repeat(" ", (lenl)) + strdata + repeat(" ", lenr ) + "\n"); 	
		int lcentre = (left.height() == 1? 0 : centre(stal[0])); 	
		int rcentre = (right.height() == 1? 0 :centre(star[0])); 	
		res.append(repeat(" ",lcentre) + "+" + repeat("-",lenl-lcentre-1) + "+" + repeat("-",rcentre-1+strdata.length()) +  "+" + repeat(" ",lenr-rcentre -1) + "\n");
		res.append(repeat(" ",lcentre) + (left.height()==1? " " : "|") + repeat(" ",lenl-lcentre-1) +  repeat(" ",rcentre + strdata.length()) +  (right.height()==1? " " : "|") + repeat(" ",lenr-rcentre-1) +"\n"); 	
		for(int i = 0;i<Math.max(stal.length, star.length);i++) { 
			res.append( (i<stal.length ? stal[i] : repeat(" ", lenl)) +repeat(" ",strdata.length()) +  (i<star.length? star[i] : repeat(" ", lenr)) + "\n"); 
			} 		
		return res.toString();
		
		
	}
	
	protected String repeat(String string, int n) { 		
		String res = "     "; 		
		for (int i = 0; i<n;i++) res += string; 	
		return res; 	
	}
	protected int centre(String string) { 		
		int i = 0;
		while (i < string.length() && string.charAt(i) == ' ') i++; 		
		return i; 	
	}
	

}