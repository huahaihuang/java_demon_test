package test;

import java.util.concurrent.CountDownLatch;

class Controller implements Runnable{
	
	private CountDownLatch latch;
	
	public Controller(CountDownLatch latch){
		super();
		this.latch=latch;
	}

	@Override
	public void run() {
		try {
			latch.await();  //调用此方法会一直阻塞当前线程，直到计时器的值为0
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("所有任务都完成，任务完成");			
	}
}
