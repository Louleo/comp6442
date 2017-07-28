import java.util.Scanner;


public class Shape {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("please enter an odd which is between 3 and 15");
		int n = input.nextInt();
		int a = (n+1)/2;
	    for (int i=1;i<=a;i++){
	    	for(int j=1;j<=a-i;j++){
	    		System.out.print(" ");
	    	}
	    	for(int c=1;c<=2*i-1;c++){
	    		System.out.print("#");
	    	}
	    	System.out.print("\n");	    	
	    }
	    for (int i=a+1;i<=n;i++){
	    	for(int j=1;j<=i-a;j++){
	    		System.out.print(" ");
	    	}
	    	for(int c=1;c<=n-2*(i-a);c++){
	    		System.out.print("#");
	    	}
	    	System.out.print("\n");	    	
	    }
	}
}
