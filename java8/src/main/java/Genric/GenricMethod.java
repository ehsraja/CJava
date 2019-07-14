package Genric;

import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

public class GenricMethod {
	
	// Generic singleton factory pattern
	private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;
	@SuppressWarnings("unchecked")
	public static <T> UnaryOperator<T> identityFunction() {
	return (UnaryOperator<T>) IDENTITY_FN;
	}
	
	public static Set union1(Set s1, Set s2) {
		Set result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}
	
	public static <E> Set<E> union3(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet <E>(s1);
		return result;
	}
	
	public  <E> Set<E> union2(Set<E> s1, Set <E> s2) {
		Set<E> result = new HashSet <E>(s1);
		result.addAll(s2);
		return result;
	}
	
	
	// Sample program to exercise generic singleton
	public static void main(String[] args) {
		String[] strings = { "jute", "hemp", "nylon" };
		UnaryOperator<String> sameString = identityFunction();
		for (String s : strings)
			System.out.println(sameString.apply(s));
		Number[] numbers = { 1, 2.0, 3L };
		UnaryOperator<Number> sameNumber = identityFunction();
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));
	}
}
