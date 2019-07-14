package java8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMerge {
	
	//https://stackoverflow.com/questions/23038673/merging-two-mapstring-integer-with-java-8-stream-api
	//https://www.baeldung.com/java-merge-maps
	//https://howtodoinjava.com/java/collections/hashmap/merge-two-hashmaps/
	
	private static Map<String, Employee> emap1 = new HashMap<>();
	private static Map<String, Employee> emap2 = new HashMap<>();
	
	public static void main(String[] args) {
		
		
		HashMap<Integer, String> map1 = new HashMap<>();
		 
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");
		map1.put(5, "E");
		
		HashMap<Integer, String> map2 = new HashMap<>();
		 
		map2.put(1, "G");   //It will replace the value 'A'
		map2.put(2, "B");
		map2.put(3, "C");
		map2.put(4, "D"); 
		
	    map1.forEach((k,v) -> map2.put(k,v));
	    
	    map1.forEach((k,v) -> map2.merge(k, v, (v1,v2) -> v1.equals(v2) ? v1 : v1+ v2   ));
	    
	    
	   
	    
	   
	    
	    
	/*  Stream.of(map1, map2)
	            .map(Map::entrySet)          // converts each map into an entry set
	            .flatMap(Collection::stream) // converts each set into an entry stream, then
                                       // "concatenates" it in place of the original set
	            .collect(
	                Collectors.toMap(        // collects into a map
	                    Map.Entry::getKey,   // where each entry is based
	                    Map.Entry::getValue // on the entries in the stream
	                             // such that if a value already exist for
	                                         // a given key, the max of the old
	                                         // and new value is taken
	                )
	            ); */
	    
	    
	    System.out.println(map2);
		
		//Mergign two maps 
		Employee employee1 = new Employee(1L, "Henry");
		emap1.put(employee1.getName(), employee1);
		Employee employee2 = new Employee(22L, "Annie");
		emap1.put(employee2.getName(), employee2);
		Employee employee3 = new Employee(8L, "John");
		emap1.put(employee3.getName(), employee3);
		 
		Employee employee4 = new Employee(2L, "George");
		emap2.put(employee4.getName(), employee4);
		Employee employee5 = new Employee(3L, "Henry");
		emap2.put(employee5.getName(), employee5);
		
		 Map<String, Employee> map3 = Stream.of(emap1, emap2)
	    		  .flatMap(map -> map.entrySet().stream())
	    		  .collect(Collectors.toMap(
	    		    Map.Entry::getKey,
	    		    Map.Entry::getValue,
	    		    (v1, v2) -> new Employee(v1.getId(), v2.getName())));
		 
		 System.out.println(map3);

		
		
	}
	
	
	static class Employee {
		  
	    public Long getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		private Long id;
	    public Employee(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		private String name;
	  
	    // constructor, getters, setters
	}

}
