package Genric;

import java.util.List;

public class WildCards {
	
    public void testCoVariance(List<? extends B> myBlist) {
        B b = new B();
        C c = new C();
        A a = new A();
        myBlist.add(b); // does not compile
        myBlist.add(c); // does not compile
        myBlist.add(a); // does not compile
        A a = myBlist.get(0); // so can be used for producing
    }


}


class A {}

class B extends A {}

class C extends B {}
