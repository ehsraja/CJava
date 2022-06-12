package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sam {
	
	public static void main(String k []) {
		findNumber(23);
	}
	
	public static void findNumber(int number) {
		number = 32 ; 
	
		 String binary = Integer.toBinaryString(number);
		  int index = binary.length() - 4 ; 
		  char  result = binary.charAt(index);
		  String s = String.valueOf(result);
		  System.out.println(s);
	
	}

}
