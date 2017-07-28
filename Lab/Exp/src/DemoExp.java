
public class DemoExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Form form = new Form();
		
		form.put("x",5);
		
		Exp e = new MultExp(new LitExp(2), new AddExp(new LitExp(3),new VarExp("x")));
		
        System.out.println(e.show() + " = "+ e.evaculate(form));
        
        Exp e1 = new MultExp(new LitExp(2), new AddExp(new LitExp(3),new LitExp(8)));
		
        System.out.println(e1.show() + " = "+ e1.evaculate(form));
	}

}
