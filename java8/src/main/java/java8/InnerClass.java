package java8;

public class InnerClass {
	
	int count = 5 ;
	String name = "Raj" ;
	final String nameEm=  "Ram" ;
	
	public int getCount() {
		return count;
	}
	public String getName() {
		return name;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	  class  NonStatic {
		  
		 public  NonStatic(){
			 System.out.println(InnerClass.this.count);
			 System.out.println(count);
			 }
		 
		 public void method1 () {
			 System.out.println(InnerClass.this.count);
			 
		  }
	}
	  
	 static  class Iamstatic {
		 public void method1 () {
			// System.out.println(count);
			 InnerClass classEg =  new InnerClass ();
		  }
		}
	 
	 public void annyonymouCalssmrthod (String local, int x) {
		 x = 10 ;
		 Thread  t = new Thread (new Runnable() {
			 public void run() {
				 System.out.println(name);
				 System.out.println(local);
		//		 System.out.println(x);
				 count++ ;
			 }
		 });
		//lamada
		 
		 //Note that lamada and inner class can access instance varialbe and final and effective final varialbe 
		 //  So access rules of lamada are same as of inner class
		 
		Thread r = new Thread( () -> {	 
			System.out.println(nameEm);
			System.out.println(name);
			 System.out.println(local);
			name  = "sdf" ;
		//	nameEm = "sdf" ;
		//	 System.out.println(x);
			 count++ ;
			    });
	 
	  // annonumous class
		class methodInner {
			public void method2 () {
				System.out.println(nameEm);
			}
		}
	 
	 }
	 
	 public static void main(String[] args) {
		
		 
	}
	

}
