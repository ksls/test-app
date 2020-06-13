import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Person {
	
	private String name;
	private int age;
	private String gender;
	
	private String interests;
	
	private Map <String, String> attr = new HashMap<String, String>();
	
	public Person(){
		
	}
	
public Person(String name, int age, String gender, String interests, Map <String, String> attrb){
	
	if(name == null || gender == null ){
		throw new IllegalArgumentException("Name/Gender can't be null");
	}
	
	if(age <0){
		throw new IllegalArgumentException("Invalid age value, age:"+age);
	}
	this.name  = name;
	this.age = age;
	this.gender = gender;
	this.interests = interests;
	if(null != attrb){
		attr.putAll(attrb);
	}
	
	
		
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public Map<String, String> getAttr() {
	return attr;
}

public void setAttr(Map<String, String> attr) {
	this.attr = attr;
}

public String getInterests(){
	return this.interests;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((gender == null) ? 0 : gender.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Person))
		return false;
	Person other = (Person) obj;
	if (age != other.age)
		return false;
	if (gender == null) {
		if (other.gender != null)
			return false;
	} else if (!gender.equals(other.gender))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + ", gender=" + gender
			+ ", interests=" + interests + "]";
}
	

}
