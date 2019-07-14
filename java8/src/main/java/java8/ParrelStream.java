package java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParrelStream {
	
	public static void main(String[] args) {
		Stream <String> words = Stream.of("Abc","cbc","dfdfdsdffds");
		
		int[] shortWords = new int[12];
		words.parallel().forEach(
		s -> { if (s.length() < 12) 
			shortWords[s.length()]++; });
		// Error—race condition!
		System.out.println(Arrays.toString(shortWords));
	}

}
