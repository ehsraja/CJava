package com.sam.Threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SamBarrier implements  Runnable {
	
	static CyclicBarrier barrier  = new CyclicBarrier(5);
	
	public void run() {
		System.out.println(Thread.currentThread().getName() +" : " + "Preparing launchpad");
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		System.out.println(Thread.currentThread().getName() +" : " +" Lauching Roacket");
	}
 
	public static void main(String k []){
		Thread thread1  = new Thread (new SamBarrier(), "MyThread1");
		Thread thread2  = new Thread (new SamBarrier(),"MyThread2");
		Thread thread3  = new Thread (new SamBarrier(),"MyThread3");
		Thread thread4  = new Thread (new SamBarrier(),"MyThread4");
		Thread thread5  = new Thread (new SamBarrier(),"MyThread5");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		System.out.println("Ending");
	}
	
	

}
