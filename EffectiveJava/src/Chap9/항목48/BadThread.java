package Chap9.항목48;

public class BadThread extends Thread{
//안좋은 쓰레드
	Foo foo;
	public void run(){
		foo = Foo.getFoo();
		int[] vals;
		System.out.println("val1 = "+foo.getVal1());
		System.out.println("val2 = "+foo.getVal2());
		vals=foo.getVals();
		for(int i=0;i<foo.SIZE;i++)
			System.out.print(vals[i]+", ");
	}
	public static void main(String[] args)
	{
		BadThread bt1 = new BadThread();
		BadThread bt2 = new BadThread();
		bt1.start();
		bt2.start();
		try{
			bt1.join();
			bt2.join();
			
		}catch(InterruptedException e){
			System.out.println("Main Thread Interrupted");
		}
		System.out.println("Main Thread Exiting...!");
	}
}

class Foo{
	private int val1;
	private int val2;
	private int[] vals;
	public static final int SIZE=100;
	//초기화를 하지않아 오류.
	private static Foo foo = new Foo();
	
	public static Foo getFoo(){
		if(foo==null){
			synchronized (Foo.class) {
				if(foo==null)
					foo = new Foo();
			}
		}
		return foo;
	}
	
	Foo(){
		val1=10;
		val2=20;
		vals=new int[SIZE];
		for(int i=0;i<SIZE;i++)
			vals[i]=i;
	}
	public int getVal1(){
		return val1;
	}
	public int getVal2(){
		return val2;
	}
	public int[] getVals(){
		return vals;
	}
	
	
}


