package blockq;

import java.util.LinkedList;
import java.util.List;

public class BlockingQue {
	public List<String> que=new LinkedList<>();
	public int MAXSIZE=10;
	public BlockingQue(int maxsize) {
		this.MAXSIZE=maxsize;
	}
	public void producer() throws InterruptedException {
		synchronized (this) {
			while(que.size()==MAXSIZE) {
				wait();
			}
			que.add("Object");
			if(que.size()!=0) {
				notifyAll();
			}

			System.out.println("producer::"+que.size());
		}
		
	}
	public void consumer() throws InterruptedException {
		synchronized (this) {
			while (que.size()==0) {
				wait();				
			}			
			que.remove(0);
			if(que.size()==0) {
				notifyAll();
			}
			System.out.println("consumer:::"+que.size());
		}
	}

	public static void main(String[] args) {
		BlockingQue que=new BlockingQue(10);
		Runnable th=()->{
			while (true) {
				try {
				que.consumer();	
				Thread.sleep(900);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		};		
		Runnable th1=()->{
			while (true) {
				try {
				que.producer();	
				Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		};
		new Thread(th).start();
		new Thread(th1).start();

	}

}
