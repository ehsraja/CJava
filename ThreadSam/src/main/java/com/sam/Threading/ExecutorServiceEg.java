package com.sam.Threading;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceEg {
	
	private static class fileReader implements  Callable <String> {
		
		int x ;
		public fileReader(int x){
			this.x = x ;
		}
		
		public String  call() throws InterruptedException {
			int total = 0  ; 
			for(int i = x ; i<10; i++){
				total = total +  i ;  
			}
			if (x == 5){
				System.out.println("slepping here : " + Thread.currentThread().getName() + " f("+ x + "): " + total ) ; 
				Thread.sleep(10000);
			}
			System.out.println(Thread.currentThread().getName() + " f("+ x + "): " + total);
		    return (" f("+ x + "): " + String.valueOf(total));
		}
		
	}
	
	
	public static void main (String k []) throws InterruptedException, ExecutionException{
	//	Thread.s
		List <Future> list = new  LinkedList<Future> ();
		ExecutorService ex = Executors.newFixedThreadPool(10);
		long startTime = Calendar.getInstance().getTimeInMillis();
		for(int i = 0 ; i <10 ; i++ ){
			Future <String> fut = ex.submit(new fileReader(i));
			list.add(fut);
		//	System.out.println(fut.get());
		}
		
		for(Future fut : list){
			System.out.println(fut.get());
		}
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Total time " + (endTime-startTime));
		
	}

}
