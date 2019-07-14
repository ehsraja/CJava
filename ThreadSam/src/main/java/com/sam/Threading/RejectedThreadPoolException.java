package com.sam.Threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectedThreadPoolException {
	

		 
	    public static void main(String[] args) {
	         
	       /* ExecutorService executor = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
	        		new ArrayBlockingQueue<Runnable>(15));*/
	    	ExecutorService executor =
	        new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));       
	 
	        Worker tasks[] = new Worker[30];
	        for(int i=0; i<30; i++){
	           tasks[i] = new Worker(i);
	        try {
	           executor.execute(tasks[i]);
	         
	        } catch(RejectedExecutionException e) {
                if (!executor.isShutdown())
                    System.out.println("task submission rejected : " + i );

	        }
	      //  executor.shutdown();       
	      //     executor.execute(tasks[0]);
	    }
	}

}	    
class Worker implements Runnable {
    
    private int ID;
     
    public Worker(int id){
        this.ID = id;
     }
 
    @Override
    public void run() {
         try{
                Thread curThread = Thread.currentThread();
                System.out.println(curThread.getName() + " currently executing the task " + ID);
                Thread.sleep(500);
                System.out.println(curThread.getName() + " just completed the task " + ID);
             }
             catch(Exception e){
                System.out.println(e);
             }
         
    }
 
    public int getID() {
        return ID;
    }
 
    public void setID(int iD) {
        ID = iD;
    }
}


