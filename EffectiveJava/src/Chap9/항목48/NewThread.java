package Chap9.�׸�48;
import java.util.*;
public class NewThread extends Thread{
String name;
private final static int NUM_ITERS=10;

//����ȭ�� ���Ѿ������� ���⼭�� ���� x
private static int nextSerialNumber=0;
public static synchronized int getSerailNumber(){
	return nextSerialNumber++;
}
NewThread(String threadname){
	name = threadname;
	System.out.println(name+" started");
}
public void run(){
	int sVal;
	for(int i=0;i<NUM_ITERS;i++){
		sVal = getSerailNumber();
		System.out.println("["+name+":"+sVal+"]");
	}
	}
	
}


