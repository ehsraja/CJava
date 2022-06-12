package Pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonSeriliazation {
	 public static void main(String[] args)  
	    { 
	        try
	        { 
	            Singleton1 instance1 = Singleton1.getSinglton() ;
	            ObjectOutput out 
	                = new ObjectOutputStream(new FileOutputStream("file.text")); 
	            out.writeObject(instance1); 
	            out.close(); 
	      
	            // deserailize from file to object 
	            ObjectInput in  
	                = new ObjectInputStream(new FileInputStream("file.text")); 
	              
	            Singleton1 instance2 = (Singleton1) in.readObject(); 
	            in.close(); 
	      
	            System.out.println("instance1 hashCode:- "
	                                                 + instance1.hashCode()); 
	            System.out.println("instance2 hashCode:- " 
	                                                 + instance2.hashCode()); 
	        }  
	          
	        catch (Exception e)  
	        { 
	            e.printStackTrace(); 
	        } 
	    } 
}


class Singleton1 implements Serializable  
{ 
    // public instance initialized when loading the class 
    public static Singleton1 instance = new Singleton1(); 
      
    private Singleton1()  
    { 
        // private constructor 
    } 
    
    public static Singleton1 getSinglton() {
    	
    	return instance ;
    }
    
} 
