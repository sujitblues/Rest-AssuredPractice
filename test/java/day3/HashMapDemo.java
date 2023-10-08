package day3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String,Integer> data=new HashMap<String,Integer>();
		data.put("Himani", 30);
		data.put("Deepika", 32);
		data.put("Krishna", 28);
		data.put("null", null);
		System.out.println(data.get("Deepika"));
		System.out.println(data);
		data.remove("null");
		System.out.println(data);
		System.out.println(data.containsKey("Rahul"));
		data.put("Anjali", 31);
		Set<String> key=data.keySet();
		System.out.println(key);
		Collection<Integer>value=data.values();
		System.out.println(value);
		
	}

}
