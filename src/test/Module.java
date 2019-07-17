package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Module implements Runnable{
	
	private CountDownLatch latch;
	
	private String name;
	
	private int random;
	
	public Module(CountDownLatch latch,String name,int random){
		this.latch=latch;
		this.name=name;
		this.random=random;
	}

	@Override
	public void run() {
		work();		
		latch.countDown(); //当前线程调用此方法，则计数减一
		
	}

	private void work() {
		 try {
			TimeUnit.MILLISECONDS.sleep(random);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	       System.out.println(name + " 完成，耗时:" + random);
	}
}
