package E2.Chap5.Ç×¸ñ28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class WildCard<E> {
	private E[] elements;
	private int size;
	private static final int DEFAULT_INITAL_CAPACITY=16;
	
	public WildCard(){
		elements = (E[])new Object[DEFAULT_INITAL_CAPACITY];
	}
	
	public void pushAll(Iterable<? extends E> src){
		for (E e:src)
			push(e);
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
	public static void main(String[] args){
		WildCard<Object> wild = new WildCard<>();
		
		List<String> str = new ArrayList<String>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++){
			list.add(i);
		}
		str.add("a");str.add("a");str.add("a");
		wild.pushAll(list);
		wild.pushAll(str);
		
		}
}
