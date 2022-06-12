package com.sam.Threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Interrruption {
	
	
	
	public static void main(String[] args) throws InterruptedException {
	    Thread taskThread = new Thread(task2ThatFinishesEarlyOnInterruption());
	    taskThread.start();      // requirement 3
	    Thread.sleep(3_000);     // requirement 4
	    taskThread.interrupt();  // requirement 5
	    taskThread.join(1_000);  // requirement 6
	}

	private static Runnable taskThatFinishesEarlyOnInterruption() {
	    return () -> {
	        for (int i = 0; i < 10; i++) {
	            System.out.print(i);      // requirement 1
	            try {
	                Thread.sleep(1_000);  // requirement 2
	            } catch (InterruptedException e) {
	               System.out.println("Interuuptted"); 
	            //	break;                // requirement 7
	            }
	        }
	    };
	}
	
	
	private static Runnable task2ThatFinishesEarlyOnInterruption() {
	    return () -> {
	    	  int i = 0 ;
	         while(true) {
	        	 if(Thread.currentThread().isInterrupted()) {
	        		 System.out.println("Interuuptted"); 
	        		 break ;
	        	 }
	            System.out.println(i++);     
	           
	        }
	    };
	}
	
}


