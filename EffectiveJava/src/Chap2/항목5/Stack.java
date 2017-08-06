package Chap2.Ç×¸ñ5;

import java.util.EmptyStackException;

public class Stack {

	private Object[] element;
	private int size=0;
	
	public Stack(int initialCapacity)
	{
		this.element=new Object[initialCapacity];
	}
	public void push(Object e)
	{
		ensureCapacity();
		element[size++]=e;
	}
	public Object pop()
	{
		if(size==0)
			throw new EmptyStackException();
		Object returnvalue = element[--size];
		element[size]=null;
		return returnvalue;
		
	}
	
	private void ensureCapacity()
	{
		if(element.length==size){
			Object[] old = element;
			element = new Object[2*element.length+1];
			System.arraycopy(old,0,element,0,size);
			
			
		}
	}
}
