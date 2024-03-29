package com.sam.Threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskTest {
	
	public static void main(String[] args) {
		MyCallable callable1 = new MyCallable(1000);
		MyCallable callable2 = new MyCallable(2000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

	//	ExecutorService executor = Executors.newFixedThreadPool(2);
	//	executor.execute(futureTask1);
	//	executor.execute(futureTask2);
		
		futureTask1.run();
		futureTask2.run();
		
		while (true) {
			try {
				if(futureTask1.isDone() && futureTask2.isDone()){
					System.out.println("Done");
					System.out.println("FutureTask1 output="+futureTask1.get());
					System.out.println("FutureTask1 output="+futureTask2.get());
					//shut down executor service
				//	executor.shutdown();
					return;
				}
				
				if(!futureTask1.isDone()){
				//wait indefinitely for future task to complete
				System.out.println("FutureTask1 output="+futureTask1.get());
				}
				
				System.out.println("Waiting for FutureTask2 to complete");
				String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
				if(s !=null){
					System.out.println("FutureTask2 output="+s);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}catch(TimeoutException e){
				//do nothing
			}
		}
		
	}
	

}


class MyCallable implements Callable<String> {

	private long waitTime;
	
	public MyCallable(int timeInMillis){
		this.waitTime=timeInMillis;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
	}

}