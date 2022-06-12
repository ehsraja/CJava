package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serial {
	
    public static void main (String k []) throws IOException, ClassNotFoundException{
    		Dog d = new Dog(35, "Fido");
           System.out.println(d.weight);
           FileOutputStream fs = new FileOutputStream("testSer.ser");
           ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(d);
            
            FileInputStream fis = new FileInputStream("testSer.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

         d = (Dog) ois.readObject();
         System.out.println(d.weight);
}


}

class Dog extends Animal implements Serializable {
	String name;
	Dog(int w, String n) {
	super(w);
		name = n; // not inherited
	}
	
	private  void writeObject(ObjectOutputStream s) throws IOException {
		System.out.println("here in write object");  
		s.defaultWriteObject();
		s.writeInt(weight);
	}
	
	private  void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		System.out.println("here in read object");  
		s.defaultReadObject();
		System.out.println(s.readInt());
	}
	
}
class Animal { // not serializable !
	int weight = 42;
	public Animal (int w){
		this.weight = w ;
	}
	
	public Animal() {
		
	}
}
