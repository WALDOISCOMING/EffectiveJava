package Chap10.항목55;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StringList implements Serializable{
	public transient int size=0;
	public transient Entry head = null;
	
	public static class Entry{
		String data;
		Entry next;
		Entry previous;
		
	}
	
	public void add(String s){
		head.next.data=s;
	}
	//인스턴스화
	private void writeObject(ObjectOutputStream s) throws IOException{
		s.defaultWriteObject();
		s.writeInt(size);
		for(Entry e=head;e!=null;e=e.next){
			s.writeObject(e.data);
		}		
	}
	
	private void readObject(ObjectInputStream s)throws IOException,ClassNotFoundException{
		s.defaultReadObject();
		int numElement=s.readInt();
		for(int i=0;i<numElement;i++)
			add((String)s.readObject());
	}
	
}
