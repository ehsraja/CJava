package java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Streams {

    public static void main(String[] args) {
    
    	
    	//forEach
    	
    	 IntStream stream = "12345_abcdefg".chars();
         stream.forEach(p -> System.out.println(p));
         
         //OR
          
         Stream<String> stream2 = Stream.of("A$B$C".split("\\$"));
         stream2.forEach(p -> System.out.println(p));
         
         //Filter
         
         List<String> memberNames = new ArrayList<>();
         memberNames.add("Amitabh");
         memberNames.add("Shekhar");
         memberNames.add("Aman");
         memberNames.add("Rahul");
         memberNames.add("Shahrukh");
         memberNames.add("Salman");
         memberNames.add("Yana");
         memberNames.add("Lokesh");
         
         
         memberNames.stream().filter((s) -> s.startsWith("A"))
         .forEach(s -> System.out.println(s));
         
         
         memberNames.stream().filter((s) -> s.equals("Aman")).collect(Collectors.toList());
        
         
         
         
         
         
         
         //Default method example 
         
         System.out.println("Infinte stream");
         memberNames.stream().filter((s) -> s.startsWith("A"))
         .forEach(System.out::println);
         
         // forEach termination method
         
         memberNames.stream().sorted()
         .map(String::toLowerCase)
         .forEach(System.out::println);
         
         // collect termination method
         
         List<String> memNamesInUppercase = memberNames.stream().sorted()
                 .map(String::toUpperCase)
                 .collect(Collectors.toList());
         
         
         System.out.print(memNamesInUppercase);
         

         // reduce termination method
         
         Optional<String> reduced = memberNames.stream()
                 .reduce((s1,s2) -> s1 + "#" + s2);
         
         System.out.println(reduced.get());

          reduced.ifPresent(System.out::println);
          
          System.out.println("____________________");
          
          String contents = "UVVU RRR" ;
          
          Stream<String> words
          = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
          
          words.forEach(System.out::println);


	}
}
