import java.util.Scanner;

public class Counter {
	
	static Boolean open = true;
	
	
	public Value parseCommand(String s, Value v){
		if(s.equals("i")){
			v.increase();
			return v;
		}else if(s.equals("r")){
			v.reset();
			return v;
		}else{
			v.value = -1;
			return v;
		}

	}
	
	
	public static void close(){
		open = false;
		System.out.println("Done.");
	}
}
