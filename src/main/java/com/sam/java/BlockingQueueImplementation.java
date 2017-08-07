package com.sam.java;

import java.util.ArrayList;
import java.util.List;

public class  BlockingQueueImplementation <T> {
	
	private List <T> queue = new ArrayList <T>();
	private int top = 0 ;
	private int head = 0 ;
	private int size = 0 ;
	private int capacity ;
	
	public  BlockingQueueImplementation  (int capacity){
		this.capacity = capacity ;
	}
	
	public T get() throws InterruptedException{
		T t = null; 
		 synchronized (queue) {
			 if(size == 0 ){
				 queue.wait();
			 }
				 t =  queue.remove(head);
				 System.out.println("getting " +  t);
				 movePostion(head);
				 checkIfneedtoNotify();
				 size --; 
			
		}
		return t ; 
	}
	
	 private void movePostion(int position){
		 if(position == capacity-1){
			 position = 0 ; 
		 } else 
			 position ++; 
	 }
	 
	 private void checkIfneedtoNotify(){
		 synchronized (queue) {
		 if (size == capacity || ( size == 0) ) {
			 queue.notify();
		 }
	   } 
	 }

	
	public void put(T t) throws InterruptedException{
		 synchronized (queue) {
		if ( size == capacity){
			 queue.wait();
		}
			queue.add(t);
			 movePostion(top);
			 checkIfneedtoNotify();
			 size ++; 
			 System.out.println("putting " +  t);
		
		 }
	}
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueueImplementation <Integer> queue = new BlockingQueueImplementation <Integer>(4)   ;
		Thread putThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
			for(int i = 0 ; i<10 ; i ++ ){
				try {
					queue.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}	
		});
		putThread.start();
		
        Thread getThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
			        for(int i = 0 ; i< 10 ; i++){
					    
			        	try {
			           Thread.sleep(3000);
						queue.get();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      }
			}	
		});
        getThread.start();
		
	}
}
