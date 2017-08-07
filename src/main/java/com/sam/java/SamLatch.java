package com.sam.java;

import java.util.concurrent.CountDownLatch;

public class SamLatch implements  Runnable{
	
	static CountDownLatch myfirstLatch = new CountDownLatch(5);
//	static CountDownLatch startLatch = new CountDownLatch(1);
	
	public void run() {
	    for(int i=0;i<=10;i++){
	    	System.out.println(Thread.currentThread().getName() + ":" + i);
	    }
	    myfirstLatch.countDown();
	}

	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("starting");
		
		Thread thread1  = new Thread (new SamLatch(), "MyThread1");
		Thread thread2  = new Thread (new SamLatch(),"MyThread2");
		Thread thread3  = new Thread (new SamLatch(),"MyThread3");
		Thread thread4  = new Thread (new SamLatch(),"MyThread4");
		Thread thread5  = new Thread (new SamLatch(),"MyThread5");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		//startLatch.countDown();
		myfirstLatch.await();
		System.out.println("Ending");
		
	}

   
	
}
   




