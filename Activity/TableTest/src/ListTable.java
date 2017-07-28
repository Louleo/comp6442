import java.awt.Color;
import java.util.ArrayList;


/*
 * ListTable - This implementation uses a list of KeyValues to store the table.  
 * This is one of the simplest approaches for storing such a table.  However,
 * it is not particular fast in terms of adding element or looking them up.    
 */


public class ListTable implements Table {
	
	ArrayList<String> values = new ArrayList<>();
	ArrayList<Integer> keys = new ArrayList<>();
	ArrayList<KeyValue> list = new ArrayList<>();// add fields here for storing the list of key-value elements
	
	public ListTable() {
		// add code here for setting up an empty table
	}
	
	
	// insert - with a list table in most cases you can just add the new
	//          KeyValue to the end of the list.  However, the key is 
	//          already in the table you need to overwrite the value for that KeyValue. 
	@Override
	public void insert(int key, String value) {
		KeyValue kv = new KeyValue(key,value);
		try {
			int i = keys.indexOf(key);
			list.set(i, kv);
		}catch(Exception e){
			list.add(kv);
			keys.add(key);
		}

	}

	// lookup - this involved going through the list if a matching key is found 
	// the value is output.  If no match is found null is returned. 
	@Override
	public String lookup(int key) {		
        // add your code here for looking up the table.
		try{
			
			int index = keys.indexOf(key);
						
			KeyValue kv = list.get(index);
			
			return kv.getstring();
			
		}catch(Exception e){
			
			return null;
		
		}
	}

	@Override
	public Color color() {
		return Color.blue;
	}

	@Override
	public String name() {
		return "KeyValueList";
	}

}
