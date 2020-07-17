package mytests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class BasicProgTest {
	
	@Test
	public void stringHavingWords() {
		
		String test = "Bangalore is in India";
		
		String[] splittedtxt = test.split("\\s+");
		
		
		for (int i = 0; i < splittedtxt.length; i++) {
			Map<Character,Integer> countMap = new HashMap<Character, Integer>();
			
			char[] strArray = splittedtxt[i].toCharArray();
			for (char c : strArray) { 
				if (countMap.containsKey(c)) {
					countMap.put(c, countMap.get(c) + 1);
				} else {
					countMap.put(c, 1);
				}
			}
			 System.out.println("For Word "+splittedtxt[i]);
			for (Map.Entry entry : countMap.entrySet()) { 
	            System.out.println(entry.getKey() + " " + entry.getValue()); 
	        }
			
		}
		
		
	}
	
	@Test
	public void findNumber() {
		
		int x;
		
		
	}

}
