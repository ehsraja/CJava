package java8;

import java.util.Comparator;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

class Person {
	String firstName;
	String lastName;
	int age;
	String country;

	public Person(String firstName, String lastName, int age, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return firstName + "|" + lastName + "|" + age + "|" + country;
	}
	
}


class PersonUtils {
public static void sortPersons(List<Person> persons, String[] sortBy) {
	  // implement the sorting logic
	    Collections.sort(persons, new Comparator<Person>()  {
	            public int compare(Person p1, Person p2) 
	            {
	                CompareToBuilder compareBuilder = new CompareToBuilder();
	                for(String comapareWith : sortBy ){
	                   java.lang.reflect.Method method1; 
	                    java.lang.reflect.Method method2; 
	                    try {
	                     method1 = p1.getClass().getMethod(comapareWith);
	                     method2 = p2.getClass().getMethod(comapareWith);
	} catch (SecurityException e) { }
	  catch (NoSuchMethodException e) {}
	                        
	                        compareBuilder.append(method1.invoke(p1), method2.invoke(p2));
	                        
	            }
	            compareBuilder.toComparison();
	            return compareBuilder;
	       }
	    });
}	    
