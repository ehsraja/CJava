package java8;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ComputeIfAbsent {
	
 public static void main(String[] args) {
	Map<String,List<String>> map = new HashMap<>();
	List <String> l1 = new LinkedList<>();
	l1.add("q");
	l1.add("q");
	l1.add("w");
	
	List <String> l2 = new LinkedList<>();
	l2.add("q");
	l2.add("q");
	l2.add("w");
	
	map.put("Ram", l1);
	map.put("Sam", l2);
	String str = "a";
	
	 List<String> l3 =  map.computeIfAbsent("Ram", (unused) -> new LinkedList<>());
	l3.add(str);
	// 
	l1.forEach(System.out::println);
	l3.forEach(System.out::println);
	
	
}	

}


