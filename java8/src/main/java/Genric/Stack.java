package Genric;

import java.util.Arrays;

public class Stack<E> {
	private E[] elements;

		private int size = 0;
		private static final int DEFAULT_INITIAL_CAPACITY = 20 ;

	public Stack() {
		elements = new E[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

public E pop() throws Exception {
if (size==0)
  throw new Exception();
E result = elements[--size];
elements[size] = null; // Eliminate obsolete reference
return result;
}

private void ensureCapacity() {
if (elements.length == size)
elements = Arrays.copyOf(elements, 2 * size
+ 1);
}
}
