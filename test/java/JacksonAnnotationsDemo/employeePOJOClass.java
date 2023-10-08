package JacksonAnnotationsDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_EMPTY)//NULL +empty both ignore 
//@JsonIgnoreProperties(value={"gender","salary"},allowGetters=true)
public class employeePOJOClass {
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	//@JsonIgnore
	private double salary;
	private boolean isMarried;
	private String[] hobbies;
	private List<String> degress;
	private Map<String,String> familyMembers;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public List<String> getDegress() {
		return degress;
	}
	public void setDegress(List<String> degress) {
		this.degress = degress;
	}
	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
	}
	
	
	
	
	

}
