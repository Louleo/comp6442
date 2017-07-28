import java.util.Arrays;
import java.util.List;

public class Operations {
    ////////////////////////////// DON'T CHANGE ANYTHING HERE\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /**
     * Binary Operator abstraction.
     */
    public interface BinaryOperator {
        // operator definition
        double op(double operand1, double operand2);

        // operator identity. identity() must be such that:
        // op(value, identity()) == op(identity(), value) == value
        double identity();
    }

    /**
     * Addition
     */
    private static BinaryOperator PLUS = new BinaryOperator() {
       // @Override
        public double op(double operand1, double operand2) {
            return operand1 + operand2;
        }

        //@Override
        public double identity() {
            return 0;
        }
    };

    /**
     * Multiplication
     */
    private static BinaryOperator TIMES = new BinaryOperator() {
        //@Override
        public double op(double operand1, double operand2) {
            return operand1 * operand2;
        }
 
        //@Override
        public double identity() {
            return 1;
        }
    };

    /**
     * Maximum
     */
    private static BinaryOperator MAX = new BinaryOperator() {
        //@Override
        public double op(double operand1, double operand2) {
            return Math.max(operand1, operand2);
        }

        //@Override
        public double identity() {
            return Integer.MIN_VALUE;
        }
    };

    ////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    /**
     * Applies the supplied operator to the entire list effectively reducing it to a single value.
     * If the list supplied list is empty, the operator's identity MUST BE returned.
     */
    private static double operate(BinaryOperator operator, List<Double> values) {
        // FOR LOOP IMPLEMENTATION HERE
        double result=0.0;
    	if (operator == PLUS){
    		int sol = values.size();
    		result = 0.0;
    		for (int i=0;i<sol;i++){
    			result = PLUS.op(result, values.get(i));
    		}
    		
    	}
    	if (operator == TIMES){
    		int sol = values.size();
    		result = 1.0;
    		for (int i=0;i<sol;i++){
    			result = TIMES.op(result, values.get(i));
    		}
    		
    	}
    	if (operator == MAX){
    		result = values.get(0);
    		int sol = values.size();
    		for (int i=1;i<sol;i++){
    			result = MAX.op(result, values.get(i));
    		}
    		
    	}
    	return result;
        //throw new IllegalStateException("You haven't implemented me yet!"); // delete this line when you begin
    }

    private static double operateRecursive(BinaryOperator operator, List<Double> values) {
        // RECURSIVE IMPLEMENTATION HERE
        // HINT: List::subList() is your friend :-)

    	if (operator == PLUS){
    		if(values.size() == 0){
    		  return 0.0;	
    		}
    		else{
    			return PLUS.op(values.get(0),operateRecursive(PLUS,values.subList(1,values.size())));
    		}
    	}
    	if (operator == TIMES){
    		if(values.size() == 0){
    		  return 1.0;	
    		}
    		else{
    			return TIMES.op(values.get(0),operateRecursive(TIMES,values.subList(1,values.size())));
    		}
    	}
    	if (operator == MAX){
    		if(values.size() == 0){
    		  return 0.0;	
    		}
    		else{
    			return MAX.op(values.get(0),operateRecursive(MAX,values.subList(1,values.size())));
    		}
    	}
        throw new IllegalStateException("You haven't implemented me yet!"); // delete this line when you begin
    }

    public static void main(String[] args) {
        // We want to generalise binary operations to operate on lists (we might want to add all of the elements
        // in a list or compute the minimum/maximum.
        List<Double> list = Arrays.asList(1.0, 2.0, 3.0, 4.0);

        // To do this, we can abstract the notion of a binary operator with the BinaryOperator interface (above)
        // and the operate() functions above. With this we can do things like:
//
//        double sum = operateRecursive(PLUS, list); 
//        double product = operateRecursive(TIMES, list); 
//        double max = operateRecursive(MAX, list); 
        double sum = operate(PLUS, list); // compute the sum of a list (this should return 10)
        double product = operate(TIMES, list); // compute the product of a list (this should return 24)
        double max = operate(MAX, list); // compute the maximum of a list (this should return 4)
        // Your task is to implement operate() (using a for loop) and operateRecursive() (via recursion)
        System.out.printf("sum(%s) is %f%n", list, sum);
        System.out.printf("product(%s) is %f%n", list, product);
        System.out.printf("max(%s) is %f%n", list, max);
    }
}
