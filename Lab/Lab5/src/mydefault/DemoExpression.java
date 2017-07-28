package mydefault;
import static mydefault.Expression.*;

public class DemoExpression {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mappings m = new Mappings();
		String exp1 = "((((3+3)*2)/3)-2)";
		Tokenizer tok = new ExpTokenizer(exp1);
		Expression e = parseExp(tok);
		System.out.println(e.show()+ " => " + e.evaculate(m));
	}

}
