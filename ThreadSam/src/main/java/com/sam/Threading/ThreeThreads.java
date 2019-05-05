package com.sam.Threading;

import java.util.concurrent.Semaphore;

/*CCI 
Question order of exceution will be 1st, 2nd , 3rd 

class UseMe {
	 
	public void  firstMethod() {
		
		System.out.println("First Method");		
	}
	
public void  secondMethod() {
	System.out.println("second Method");
	}

public void  thirdMethod() {
	
	System.out.println("Third Method");
	
}


*/
public class ThreeThreads {
	
	public static void main(String[] args) {
		 Semaphore semaphore = new Semaphore(1);
		 Semaphore semaphore2 = new Semaphore(1);
		 UseMe useMe = new UseMe() ;
		Thread thread1 = new Thread(new Runnable () {		
			public void run () {
				
				
					useMe.firstMethod();	
					semaphore.release();
				
					
			}			
		});
		Thread thread2 = new Thread(new Runnable () {		
			public void run () {
				try {
					semaphore.acquire();
				
					useMe.secondMethod();	
				
					semaphore2.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}			
		});
		Thread thread3 = new Thread(new Runnable () {		
			public void run () {
				try {
					semaphore2.acquire();
				
					useMe.thirdMethod();
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}			
		});

		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
	
	

}



 class UseMe {
	 
	public void  firstMethod() {
		
		System.out.println("First Method");		
	}
	
public void  secondMethod() {
	System.out.println("second Method");
	}

public void  thirdMethod() {
	
	System.out.println("Third Method");
	
}


	
}
