package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBYExample {
	
	static List<Employee> employeeList = Arrays.asList(
		      new Employee("Tom Jones", 45, 12000.00,Department.MARKETING),
		      new Employee("Harry Major", 26, 20000.00, Department.LEGAL),
		      new Employee("Ethan Hardy", 65, 30000.00, Department.LEGAL),
		      new Employee("Nancy Smith", 22, 15000.00, Department.MARKETING),
		      new Employee("Catherine Jones", 21, 18000.00, Department.HR),
		      new Employee("James Elliot", 58, 24000.00, Department.OPERATIONS),
		      new Employee("Frank Anthony", 55, 32000.00, Department.MARKETING),
		      new Employee("Michael Reeves", 40, 45000.00, Department.OPERATIONS));
	
	
	public static double getHighetSalary(List<Employee> emps){
	//	 return emps.stream().map(emp -> emp.getSalary()).reduce(0d,Math::max);
		
		 return emps.stream().map(emp -> emp.getSalary()).reduce(0d,(a,b)-> Double.max(a, b));
	}
	
		  public static void main(String args[]){
		    Map<Department,List<Employee>> employeeMap
		        = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		    
		    Map<Department,Double> employeeSalaryMap =  employeeMap.keySet().stream().collect(Collectors.toMap(d -> d , d -> getHighetSalary(employeeMap.get(d))));
		    System.out.println("Employees with highest Salary");
		    employeeSalaryMap.forEach(( k, v) -> System.out.println(k + ":" +   v) );
		    
		    
		    
		    System.out.println("Employees grouped by department");
		    employeeMap.forEach((Department key, List<Employee> empList) -> System.out.println(key +" -> "+empList));
		    
		    Map<Department,Long> employeeMap2 =  
	        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	        
	        
		    employeeList.stream().collect(Collectors.toMap(Employee::getDepartment,
		    		Function.identity(),(a,b)-> {
		    			if(a.getSalary() > b.getSalary()) {
		    			return a ; } else {
		    				return b ;
		    			}
		    		}
		    			));
		    
		  
		    List<String> items =
	                Arrays.asList("apple", "apple", "banana",
	                        "apple", "orange", "banana", "papaya");

	        Map<String, Long> result =
	                items.stream().collect(
	                        Collectors.groupingBy(
	                                Function.identity(), Collectors.counting()
	                        )
	                );

	        System.out.println(result);
	        
	        List<Item> items2 = Arrays.asList(
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 20, new BigDecimal("19.99")),
	                new Item("orang", 10, new BigDecimal("29.99")),
	                new Item("watermelon", 10, new BigDecimal("29.99")),
	                new Item("papaya", 20, new BigDecimal("9.99")),
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 10, new BigDecimal("19.99")),
	                new Item("apple", 20, new BigDecimal("9.99"))
	                );

			//group by price
	        Map<BigDecimal, List<Item>> groupByPriceMap = 
				items2.stream().collect(Collectors.groupingBy(Item::getPrice));
		  
		  }
		}



 
class Item {

    public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	private String name;
    private int qty;
    private BigDecimal price;
    
	public String getName() {
		return name;
	}
	public int getQty() {
		return qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    //constructors, getter/setters 
}

 class Employee {
  private String name;
  private Integer age;
  private Double salary;
  private Department department;
 
  public Employee(String name, Integer age, Double salary, Department department) {
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.department = department;
  }
 
  // Setters/Getters for name,age,salary,department go here
 
  public String toString(){
    return "Employee Name:"+this.name;
  }

public String getName() {
	return name;
}

public Integer getAge() {
	return age;
}

public Double getSalary() {
	return salary;
}

public Department getDepartment() {
	return department;
}

public void setName(String name) {
	this.name = name;
}

public void setAge(Integer age) {
	this.age = age;
}

public void setSalary(Double salary) {
	this.salary = salary;
}

public void setDepartment(Department department) {
	this.department = department;
}
 
  //Standard equals and hashcode implementations go here
 
}

 enum Department {
  HR, OPERATIONS, LEGAL, MARKETING
}