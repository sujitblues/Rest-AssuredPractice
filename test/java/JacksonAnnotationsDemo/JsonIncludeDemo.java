package JacksonAnnotationsDemo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.util.Map;
public class JsonIncludeDemo {
	
	@Test
	public void testMethod1() throws JsonProcessingException {
		
		//create payload
		employeePOJOClass emp1=new employeePOJOClass();
		emp1.setFirstName("Rahul");
		//emp1.setLastName("Roy");
		emp1.setGender("Male");
		//emp1.setAge(35);
		emp1.setSalary(100000);
		emp1.setMarried(true);
		
		//Empty Array
		String[] hobbies= {};
		emp1.setHobbies(hobbies);
		
		//Empty List
		List<String>degrees=new ArrayList<String>();
		emp1.setDegress(degrees);
		
		//empty map
		Map<String,String>familyMembers=new HashMap<String,String>();
		
		emp1.setFamilyMembers(familyMembers);
		
		
		//convert employee class object to json payload as string
		ObjectMapper objMapper=new ObjectMapper();
		
		String employeeJSON=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
	System.out.println(employeeJSON);	
	}

}
