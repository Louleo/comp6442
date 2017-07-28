import java.util.ArrayList;
/*
 * Exp 
 * Eric McCreath 2017
 */
public abstract class Exp {
	public abstract int evaluate(Subs subs, Functions funs);
	public abstract String show();
	/*
	 * <exp> ::= 0 | inc ( <exp> ) | dec ( <exp> ) | <variable> | <funtion name>
	 * ( <exps> ) | ( <exp> ? <exp> : <exp> ) <exps> ::= <exp> | <exp> , <exps>
	 * <function> ::= <function name> ( <vars> ) = <exp> <functions> ::=
	 * <function> | <function> <functions> <vars> ::= <variable> | <variable> ,
	 * <vars>
	 */
	static public Exp parseExp(Tokenizer tok) {
		if (tok.current().equals(new Integer(0))) {
			tok.next(); // consume the "0"
			return new ZeroExp();
		} else if (tok.current().equals("inc")) {
			tok.next(); // consume the "inc"
			tok.parse("(");
			Exp exp = parseExp(tok); // recursively parse the sub expression
			tok.parse(")");
			return new IncExp(exp);
		}  // add your code here
		else if(tok.current().equals("dec")){
			tok.next(); // consume the "inc"
			tok.parse("(");
			Exp exp = parseExp(tok); // recursively parse the sub expression
			tok.parse(")");
			return new DecExp(exp);
		}
		// selectexp add by Leo
		else if(tok.current().equals("(")){
			tok.next();
			Exp test = parseExp(tok);
			tok.parse("?");
			Exp exp1 = parseExp(tok);
			tok.parse(":");
			Exp exp2 = parseExp(tok);
			return new SelectExp(test, exp1, exp2);
		}
		// var add by Leo
		else if(Character.isUpperCase(tok.current().toString().charAt(0))){
			Exp exp = new VarExp(tok.current().toString());
			tok.next();
			return exp;
		}
		// functions add by Leo
		else if(Character.isLowerCase(tok.current().toString().charAt(0))){
			String fname = tok.current().toString();
			tok.next();
			tok.parse("(");
			Exp exp1 = parseExp(tok);
			if (tok.current().equals(",")){
				tok.parse(",");
				Exp exp2 = parseExp(tok);
				tok.parse(")");
				return new FunCallExp(fname,exp1,exp2);
			}else{
				tok.parse(")");
				return new FunCallExp(fname,exp1);
			}
			
		}else if(tok.current().equals("\n")){
			return null;
		}
		throw new Error();
	}
	// add by Leo
	public static Functions parseFunctions(Tokenizer tok) {
		// TODO Auto-generated method stub
		String fname = "";
		Functions functions = new Functions();
		Function function;
		Exp exp;
		Vars vars = new Vars();
		while (tok.hasNext()){
			if (tok.current().toString().matches(".*[a-z].*")){
				fname = tok.current().toString();
				tok.next();
				tok.parse("(");
			}
			if(tok.current().toString().matches(".*[A-Z].*")){
				String x = tok.current().toString();
				tok.next();
				if(tok.current().equals(",")){
					tok.parse(",");
					String y = tok.current().toString();
					tok.next();
					vars = new Vars(x,y);
					tok.parse(")");
				}else{
					vars = new Vars(x);
					tok.parse(")");
				}
				
			}		
			if(tok.current().equals("=")){
				tok.next();
				exp = parseExp(tok);
				function = new Function(fname, vars, exp);
				functions.put(fname, function);
				tok.next();
			}
			if(tok.current().equals(")")){
				tok.parse(")");
			}
			if(tok.current().equals("!")){
				tok.next();
			}
		}
		return functions;

	}
}