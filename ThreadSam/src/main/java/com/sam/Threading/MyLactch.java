package com.sam.Threading;

import java.util.concurrent.Semaphore;

public class MyLactch {
//	Semaphore semaphore ;
//	Semaphore semaphoremain =  new Semaphore(1); 
	int count = 0 ;
	int size ; 
	
	public MyLactch(int count){
	//	semaphore = new Semaphore(count);
		this.size = count ; 
	}
	
	public synchronized void await() throws InterruptedException {
	//	semaphoremain.acquire();
		this.wait();
	}
	
	
	public synchronized void countdown() throws InterruptedException{
		/*if(semaphore.availablePermits() == 5) {
			semaphore.release();
			semaphoremain.release();
		}*/
		count++ ; 
		System.out.println("count : " + count);
		if(count == size) {
			this.notify();
		}
	//	semaphore.acquire();
	}
	
	

	
	public static void main(String[] args) throws InterruptedException {
		MyLactch mylatch = new MyLactch(5);
		
		
		 class samThread implements Runnable
		{
			
			
			public void run() {
			    for(int i=0;i<=10;i++){
			    	System.out.println(Thread.currentThread().getName() + ":" + i);
			    }
			    try {
					mylatch.countdown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		Thread thread1  = new Thread (new samThread(), "MyThread1");
		Thread thread2  = new Thread (new samThread(),"MyThread2");
		Thread thread3  = new Thread (new samThread(),"MyThread3");
		Thread thread4  = new Thread (new samThread(),"MyThread4");
		Thread thread5  = new Thread (new samThread(),"MyThread5");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		mylatch.await();
		System.out.println("End");
	}
	
}
