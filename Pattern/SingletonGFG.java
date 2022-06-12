package Pattern;

import java.lang.reflect.Constructor;

 class Singleton {

	// private static Singleton instance = new Singleton(); 
	 private static Singleton instance ;
     private int count = 0 ; 
	    private Singleton() throws Exception  
	    { 
	    count++ ;
	    if(count>1) {
	      throw new Exception();
	    }	// private constructor 
	    } 
	    
	    public static Singleton getSinglton() throws Exception {
	    	if(null == instance ) {
	    		instance = new Singleton();
	    	} 
	    	return instance ;
	    }
	} 
	  
 public	 class SingletonGFG  
	{ 
	  
	    public static void main(String[] args) throws Exception 
	    { 
	    //    Singleton instance1 = Singleton.instance; 
	        Singleton instance2 = null; 
	        try
	        { 
	            Constructor[] constructors =  
	                    Singleton.class.getDeclaredConstructors(); 
	            for (Constructor constructor : constructors)  
	            { 
	                // Below code will destroy the singleton pattern 
	                constructor.setAccessible(true); 
	                instance2 = (Singleton) constructor.newInstance(); 
	                break; 
	            } 
	        } 
	      
	        catch (Exception e)  
	        { 
	            e.printStackTrace(); 
	        } 
	          
	    System.out.println("instance1.hashCode():- " 
	                                      + Singleton.getSinglton().hashCode()); 
	    System.out.println("instance2.hashCode():- " 
	                                      + instance2.hashCode()); 
	    } 
	} 
	
