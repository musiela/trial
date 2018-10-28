package trial;

import java.util.Map.Entry;
import java.util.*;

public class Phone_storage {
    final static HashMap<String, HashMap<Integer, Double>> hm = new HashMap<String, HashMap<Integer, Double>>();
	static HashMap<Integer, Double> val;
	static boolean oper = true;
	public static void main(String[] args) {
		
		try{
			
		while(oper)	{
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
		System.out.println("passed");

		System.out.println("Please type the phone number you want to search");
		Scanner sca = new Scanner(System.in);
		int phoneno  = sca.nextInt(); 
		String operator1 = "";
		int prefix = 0;
		for (Entry<String, HashMap<Integer, Double>> entry : hm.entrySet()) {
		    System.out.println("VALUE:::" +entry.getValue());
		        operator1 = entry.getKey();
		        System.out.println("Value in case 1::" + entry.getKey());
		        System.out.println("Value in case 2::" + hm.get(operator1).get(phoneno));
		        
		        for (Entry<Integer, Double> prefixes : entry.getValue().entrySet()) { 
	                prefix = prefixes.getKey();
	                System.out.println("Value in case ::"+ prefixes.getKey());
	           
		        }
		    }
		
	   } catch (Exception e) {
				System.out.println(e);
		  }
	}
    public static void func(String operator){
    	val = new HashMap<Integer, Double>();
    	System.out.println("insert phone prefix and price per minute, please type 'finish' to stop inserting");
		Scanner scann = new Scanner(System.in);
		while(scann.hasNextInt()){
			int key = scann.nextInt(); 
			double value = scann.nextDouble();
			val.put(key, value);
		    }
		hm.put(operator, val);
    }
}
