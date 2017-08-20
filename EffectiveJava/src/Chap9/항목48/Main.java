package Chap9.항목48;

public class Main {
	public static void main(String[] args)
	{
		NewThread thread1 = new NewThread("one");
		NewThread thread2 = new NewThread("two");
		thread1.start();
		thread2.start();
		try{
			thread1.join();//종료시까지 기다리자/.
			thread2.join();
		}catch(InterruptedException e){
			System.out.println("Thread Interrupted:"+e);			
		}
		
	}
}
