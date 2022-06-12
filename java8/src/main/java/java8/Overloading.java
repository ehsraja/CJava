package java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Overloading {
	
	public static void main(String[] args) {
		new Thread(System.out::println).start();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(()-> {});
		exec.submit(System.out::println);
	}

}
