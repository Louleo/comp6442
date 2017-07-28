import java.util.Scanner;


public class Fibonacci {
   public static void main(String[] args)
   {
	   Scanner keyboard = new Scanner(System.in);
	   System.out.println("enter an integer");
	   int n = keyboard.nextInt();
	   int a = 0;
	   int b = 1;
	   int j = 0;
	   for (int i=2;i<=n;i++)
	   {
		   j = a+b;
		   a = b;
		   b = j;
	   }
	   System.out.println(j);			// when the n is 2147483647(2^31-1), the program becomes very slow 
   }
}
