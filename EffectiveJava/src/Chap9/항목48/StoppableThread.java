package Chap9.�׸�48;

public class StoppableThread extends Thread{
	//stopRequested�� �����Ҷ� ����ȭ�ؾ���.
	private boolean stopRequested=false;
	String name;
	StoppableThread(String threadname) {
		name=threadname;
		// TODO Auto-generated constructor stub
	}

	public void run(){
	boolean done = false;
	while(!stopRequested()&&!done){
		System.out.println("["+name+"]");
	}
	System.out.println("\n\n Thread "+name+"\tExiting..!");	
	}
	/*
	public void requestStop(){
		stopRequested=true;		
	}
	
	�Ʒ��� ����ȭ ��������� ��ü
	*/
	public synchronized void requestStop(){
		stopRequested=true;
	}
	public synchronized boolean stopRequested(){
		return stopRequested;
	}
	
	public static void main(String[] args){
		StoppableThread st1 = new StoppableThread("one");
		StoppableThread st2 = new StoppableThread("two");
		st1.start();
		st2.start();
		try{
			Thread.sleep(1000);
			st1.requestStop();
			st2.requestStop();
			st1.join();
			st2.join();
			
		}catch(InterruptedException e){
			System.out.println("Interrupted"+e);		
		}
		System.out.println("Main Thread exiting");
	}
}
