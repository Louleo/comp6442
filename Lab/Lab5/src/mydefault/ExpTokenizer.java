package mydefault;

public class ExpTokenizer extends Tokenizer  {
	String text; // the text to be tokenizer
	int pos; // position the tokenizer is currently pointing at.
	Object current; // the current token that has just been tokenized, noting
					// the "pos" will point just after the text of this token
	Object prev;
	public ExpTokenizer(String text) {
		this.text = text;
		pos = 0;
		next();
	}

	@Override
	boolean hasNext() {
		return current != null;
	}

	@Override
	Object current() {
		return current;
	}

	@Override
	void next() {
		prev = current;
		char c = 0;
		int textlen = text.length();

		
		if (pos < textlen)
			c = text.charAt(pos);

		
		// consume the white space
//		if (c == ','){
//			pos++;
//			next();
//		}
		// by Leo while() will be good
		
		while(c == ' '){
			pos++;
			if (pos < textlen){
				c = text.charAt(pos);
			}
			else{
				c = 0;
				break;
			}
		}
		
		// modify this code
//		if (c == '\n' ){
//			pos++;
//			current = "!";
//			return;
//		}
		

		if (pos >= textlen) {
			current = null;
			return;
		} else if (c == '(') {
			pos++;
			current = "(";
			return;
		} else if (Character.isDigit(c)) {
			String res = "" + c;
			if(pos <textlen-1){
			pos++;
			c = text.charAt(pos);
			while (pos < textlen && Character.isDigit(c)) {
				res += c;
				pos++;
				c = text.charAt(pos);
			}
			}
			current = Integer.parseInt(res);
			return;
		} else if (c == ')'){
			pos++;
			current = ")";
			return;
		}else if(Character.isAlphabetic(c)){
			String res = "" + c;
			pos++;
			c = text.charAt(pos);
			while (pos < textlen && Character.isAlphabetic(c)) {
				res += c;
				pos++;
				c = text.charAt(pos);
			}
			
			current = res;
			return;
		} else if (c == '+'){
			pos++;
			current = "+";
			return;
		}else if (c == '-'){
			pos++;
			current = "-";
			return;
		}else if (c == '*'){
			pos++;
			current = "*";
			return;
		}
			else if (c == '/'){
			pos++;
			current = "/";
			return;
		}

	}

	@Override
	Object prev() {
		// TODO Auto-generated method stub
		return prev;
	}

}