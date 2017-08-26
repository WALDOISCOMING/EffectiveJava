package E2.Chap5.Ç×¸ñ26;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
	private E[] elements;
	private int size;
	private static final int DEFAULT_INITAL_CAPACITY=16;
	@SuppressWarnings("unchecked")
	public Stack(){
		
		elements = (E[])new Object[DEFAULT_INITAL_CAPACITY];
	}
	public void push(E e){
		ensureCapacity();
		elements[size++]=e;		
	}
	public E pop(){
		if(size==0)
			throw new EmptyStackException();
		@SuppressWarnings("unchecked")
		E result=(E)elements[--size];
		elements[size]=null;
		return result;
	}
	public boolean isEmpty(){
		return size==0;
	}
	
	private void ensureCapacity(){
		if(elements.length==size)
			elements=Arrays.copyOf(elements,2*size+1);
	}

}
