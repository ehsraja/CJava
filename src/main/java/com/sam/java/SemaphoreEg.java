package com.sam.java;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreEg {
	
	private Set<Object>  set = new HashSet <Object>();
	
	private Semaphore semaphore = new Semaphore(5);
	
	
	public void put(Object obj) throws InterruptedException{
		System.out.println("Putting :" + obj);
		semaphore.tryAcquire(2, TimeUnit.SECONDS);
		System.out.println(semaphore.availablePermits());
		set.add(obj);
		System.out.println(set.size());
	}
	
	
	public void get(Object obj){
		set.remove(obj);
		semaphore.release();
	}
	
	public int size(){
		return set.size();
	}
	
	public static void main(String[] args) throws InterruptedException {
		SemaphoreEg eg = new SemaphoreEg ();
		eg.put("Ram");
		eg.put("Sam");
		eg.put("Ram");
		eg.put("Ram");
		eg.put("Ram");
		eg.put("Rym");
		System.out.println(eg.size());
		eg.get("Ram");
		eg.get("Sam");
		eg.put("Ryme");
	}
	
}
