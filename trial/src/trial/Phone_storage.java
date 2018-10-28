package trial;

import java.util.Map.Entry;
import java.util.*;

public class Phone_storage {
    final static HashMap<String, HashMap<Integer, Double>> hm = new HashMap<String, HashMap<Integer, Double>>();
	static HashMap<Integer, Double> val;
	static boolean oper = true;
	static HashMap<String, Double> values = new HashMap<String, Double>();
	public static void main(String[] args) {
		
		try{
		   while(oper){
			System.out.println("please insert the name of operator");
			Scanner scan = new Scanner(System.in);
			String operator = scan.nextLine(); 
			if (operator != null && !operator.isEmpty()) {
				func(operator);
				
			    }
				 
		     System.out.println("type 'yes' if you want to add another operator, else type 'no'.");
		     String another = scan.nextLine();
		     if(another.equalsIgnoreCase("no")){
		    	oper = false;
		    	break;
		     }
		     else if(another.equalsIgnoreCase("yes")){
		    	 continue;
		     }
		   }	
		//System.out.println("passed");

		System.out.println("Please type the phone number you want to search");
		Scanner sca = new Scanner(System.in);
		String phoneno  = sca.nextLine(); 
		String operator1 = "";
		String prefix = "";
		int prefix_length = 0;
		Integer longest_prefix = 0;
		for (Entry<String, HashMap<Integer, Double>> entry : hm.entrySet()) {
			operator1 = entry.getKey();
	        System.out.println("name of operator::" + entry.getKey());
		    System.out.println("price lists in this operator:::" +entry.getValue());
	        for (Entry<Integer, Double> prefixes : entry.getValue().entrySet()) { 
                prefix = Integer.toString(prefixes.getKey());
                if((phoneno.startsWith(prefix)) && (prefix.length() > prefix_length)){
                	prefix_length = prefix.length();
                	longest_prefix = Integer.parseInt(prefix);
                }
                //System.out.println("phone prefix ::"+ prefixes.getKey());
		        }
		        Double price = hm.get(operator1).get(longest_prefix);
		        values.put(operator1, price);
		    }
		
		Entry<String, Double> min = null;
		for (Entry<String, Double> entry : values.entrySet()) {
		    if (min == null || min.getValue() > entry.getValue()) {
		        min = entry;
		    }
		}
		System.out.println("Operator " + min.getKey() + "has the minimum price of " + min.getValue() + "cents");
		
	   } catch (Exception e) {
		      System.out.println(e);
	     }
	}
    public static void func(String operator){
    	val = new HashMap<Integer, Double>();
    	System.out.println("insert phone prefix and price per minute, please type 'finish' or any word to stop inserting");
		Scanner scann = new Scanner(System.in);
		while(scann.hasNextInt()){
			int key = scann.nextInt(); 
			double value = scann.nextDouble();
			val.put(key, value);
		    }
		hm.put(operator, val);
    }
}
