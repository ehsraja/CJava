import java.util.List;

public class PECS {
	
	public enum Operation {
		PLUS, MINUS, TIMES, DIVIDE;
		// Do the arithmetic op represented by this constant
		double apply(double x, double y) {
		switch(this) {
		case PLUS: return x + y;
		case MINUS: return x - y;
		case TIMES: return x * y;
		case DIVIDE: return x / y;
		}
	//	throw new AssertionError("Unknown op: " + this);
		}
		}
	


	     class A {}

	      class B extends A {}

	     class C extends B {}

	    public void testCoVariance(List<? extends B> myBlist) {
	        B b = new B();
	        C c = new C();
	        A a = new A();
	        myBlist.add(b); // does not compile
	        myBlist.add(c); // does not compile
	        A a = myBlist.get(0); // so can be used for producing
	    }

	    public void testContraVariance(List<? super B> myBlist) {
	        B b = new B();
	        C c = new C();
	        A a = new A();
	        myBlist.add(b);
	        myBlist.add(c);
	        myBlist.add(a);
	        A a = myBlist.get(0); // does not compile
	    }
	}

}
