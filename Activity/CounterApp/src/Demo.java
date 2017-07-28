import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input your command.");
		Scanner scan = new Scanner(System.in);
		Counter c = new Counter();
		Value v = new Value(0);
		String command = scan.next();
		
		while(c.open){
			if(command.equals("q")){
				c.close();
				break;
			}else{
				c.parseCommand(command, v);
				if(v.value != -1){
					System.out.println(v.show());
				}else{
					System.out.println("Please input valid command like i, r, q");
				}
			}
			command = scan.next();
		}
	}
	

}
