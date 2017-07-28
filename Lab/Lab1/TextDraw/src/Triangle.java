
public class Triangle implements TextDraw {

	public void draw() {
		// TODO Auto-generated method stub
        for(int i = 1;i<6;i++){
        	for(int j=1; j<i; j++){
        		System.out.print("#");
        	}
        	System.out.print("\n");
        }
	}

}
