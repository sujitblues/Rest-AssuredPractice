package JacksonAnnotationsDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreDemo {
	@Test
	public void testMethod1() throws JsonProcessingException {
		
		//create payload
		employeePOJOClass emp1=new employeePOJOClass();
		emp1.setFirstName("Rahul");
		//emp1.setLastName("Roy");
		//emp1.setGeneder("Male");
		//emp1.setAge(35);
		emp1.setSalary(100000);
		emp1.setMarried(true);
		
		
		
		//convert employee class object to json payload as string
		ObjectMapper objMapper=new ObjectMapper();
		
		String employeeJSON=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
	System.out.println(employeeJSON);	
	}
}
