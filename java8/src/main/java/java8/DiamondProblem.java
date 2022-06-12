package java8;


 interface A{   
	  default void display() {
		  System.out.println("A");
	  }//code goes here }
//	}
 }	  
  interface B extends A{
	
	  default void display() { //code goes here }
		  System.out.println("B");
		}
  }
 interface C extends A{ 
	  default void display() { 
		  System.out.println("C");//code goes here }
		}

	 
 }
	
	
	public class DiamondProblem implements C {
		
		public void displayit() { 
		  C.super.display();       
		  }
		
		/*public void display() { 
			System.out.println("D");//code goes here }
		}*/
		
	/*	@Override
		public void display() {
			// TODO Auto-generated method stub
		//	B.super.display();
		}*/

		public static void main(String[] args) {
			DiamondProblem d = new DiamondProblem();
			d.display();
		}
	}
		
	
	

