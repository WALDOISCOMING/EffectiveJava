package Chap9.Ç×¸ñ49;

import java.util.*;

public abstract class WorkQue {
	private final List queue = new LinkedList();
	private boolean stopped = false;
	protected WorkQue(){
		new WokerThread().start();
	}
	public final void enqueue(Object workItem){
		synchronized (queue) {
			queue.add(workItem);
			queue.notify();
		}
	}
	public final void stop(){
		synchronized (queue) {					
			stopped=true;
			queue.notify();
		}		
	}
	protected abstract void processItem(Object workItem)
			throws InterruptedException;
	private class WokerThread extends Thread{
		public void run(){
			while(true){
				Object workItem = null;
				synchronized (queue) {
					try{
						while(queue.isEmpty()&&!stopped)
							queue.wait();
					}catch(InterruptedException e){
						return ;
					}
					if(stopped)
						return;
					workItem=queue.remove(0);
					
				}
				try{
					processItem(workItem);
				}catch(InterruptedException e){
					return ;
				}
			}
		}
	}
}
