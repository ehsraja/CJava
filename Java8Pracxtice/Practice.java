package Java8Pracxtice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
	
	public static void main(String[] args) {
		
       int [] numbers = {1,5,3,63,22,3434}; 
		
		int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		
		int max = Arrays.stream(numbers).reduce(0, (a,b) -> {return  Integer.max(a,b);}) ;
		
		System.out.println(max);
		
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream().map(s -> { return  s.length();})
	//	.map(String::length)
		.collect(Collectors.toList());


		
	}

}
