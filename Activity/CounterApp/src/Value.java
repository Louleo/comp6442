
public class Value {
	int value;
	public Value(int v){
		value = v;
	}
	
	public void increase(){
		value += 1;
	}
	
	public void reset(){
		value = 0;
	}
	
	public int show(){
		return value;
	}
}
