import java.util.ArrayList;
import java.util.Random;


public class Value {
	public static void main(String[] args) {
		int n=10;
		ArrayList<Integer> arrayRandom = new ArrayList<Integer>(n);

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i=0; i<n; i++)
		{
		    Integer r = rand.nextInt() % 256;
		    arrayRandom.add(r);
		}
		Integer max=arrayRandom.get(0);
		Integer min=arrayRandom.get(0);
		
		for (int j=0; j<n; j++)
		{
			Integer inuse = arrayRandom.get(j);
			if(inuse>max){
				max = inuse;
			}
			if(inuse<min){
				min = inuse;
			}
		}
		System.out.println(max);
		System.out.println(min);
		
	  }
}
