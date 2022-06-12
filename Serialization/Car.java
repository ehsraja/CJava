package Serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Car implements Externalizable{
	
	 static int age; 
	    String name; 
	    int year; 
	  
	    public Car() 
	    { 
	        System.out.println("Default Constructor called"); 
	    } 
	  
	    Car(String n, int y) 
	    { 
	        name = n; 
	        year = y; 
	        age = 10; 
	    } 
	    
	    public String toString() 
	    { 
	        return ("Name: " + name + "\n" +  
	               "Year: " + year + "\n" +  
	               "Age: " + age); 
	    } 

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		 out.writeObject(name); 
	        out.writeInt(age); 
	        out.writeInt(year); 
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		 name = (String)in.readObject(); 
	        age = in.readInt(); 
	        year = in.readInt(); 
		
	}
	
	public static void main(String[] args) 
    { 
        Car car = new Car("Shubham", 1995); 
        Car newcar = null; 
  
        // Serialize the car 
        try { 
            FileOutputStream fo = new FileOutputStream("gfg.txt"); 
            ObjectOutputStream so = new ObjectOutputStream(fo); 
            so.writeObject(car); 
            so.flush(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
  
        // Deserializa the car 
        try { 
            FileInputStream fi = new FileInputStream("gfg.txt"); 
            ObjectInputStream si = new ObjectInputStream(fi); 
            newcar = (Car)si.readObject(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
  
        System.out.println("The original car is:\n" + car); 
        System.out.println("The new car is:\n" + newcar); 
    } 
	

}
