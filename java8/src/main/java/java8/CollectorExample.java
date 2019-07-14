package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CollectorExample {

	public static void main(String[] args) {
		Map<String,Long > freq = new HashMap <>() ;
		freq.put("c", 1L);
		freq.put("d", 2L);
		freq.put("ddf", 4L);
		freq.put("343", 8L);
		freq.put("er", 34L);
		freq.put("df", 33L);
		freq.put("d", 40L);
		freq.put("343", 28L);
	  
		System.out.println("Hello");
		List<String> topTen = freq.keySet().stream()
		.sorted(Comparator.comparing(freq::get).reversed())
		.limit(4)
		.collect(Collectors.toList());
		System.out.println("end");
		System.out.println(topTen);
		System.out.println("world");
		
		
		List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Hello");
        list.add("World");

        Map<String, Long> counted = list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        Map<String, Long> counted2 = list.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        
        Map<String, List<String>> counted4 = list.stream().collect(Collectors.groupingBy(String::toLowerCase));//, Collectors.counting()));
        
        System.out.println(" counted4 : " + counted4);
        
        
        System.out.println(" counted : " + counted);
        System.out.println( " counted2 : " + counted2);
        System.out.println("world");
        
        //Q list number of recouuring world 
        //2 Remove the number having frequency less then 1 
        
        List<Integer> integers =  Arrays.asList(1, 2, 3,4,3,2,3,5,7,3); 
        Map<Integer, Long> counted3 = integers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        System.out.println(counted3);
        System.out.println("world");
        
        counted3.values().removeIf(l -> l < 1);
        
	}
}
