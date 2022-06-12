package java8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Java8Map {
	
	public static void main(String[] args) {
		List<Long> list = new LinkedList<Long>();
		list.add(1L);
		Map<Long,String> map = new HashMap <Long,String> ();
		list.stream().forEach( k-> System.out.println(k));
		
	}

}
