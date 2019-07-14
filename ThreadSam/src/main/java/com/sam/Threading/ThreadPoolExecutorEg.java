package com.sam.Threading;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



public class ThreadPoolExecutorEg {
	
private static class Counter implements  Callable <String> {
		
		int x ;
		public Counter(int x){
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
    	 List <Future> list = new  LinkedList<Future> ();
    	 int corePoolSize = 5 ;
    	 int maxPoolSize = 10 ;
    	 long  keepAliveTime = 5;
    	 TimeUnit unit  = TimeUnit.SECONDS  ;
    	 BlockingQueue <Runnable> queue = new LinkedBlockingQueue<Runnable>();
    	 ExecutorService threadPoolExecutor =
    		        new ThreadPoolExecutor(
    		                corePoolSize,
    		                maxPoolSize,
    		                keepAliveTime,
    		                unit,
    		                queue
    		                );
    	 
    	 for(int i = 0 ; i <10 ; i++ ){
 			Future <String> fut = threadPoolExecutor.submit(new Counter(i));
 			System.out.println(fut.get());
 			
 		}
     }

}
