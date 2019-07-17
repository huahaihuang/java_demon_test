package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	public static void main(String[] args){
		 ExecutorService service = Executors.newFixedThreadPool(10);
		 CyclicBarrier barrier = new CyclicBarrier(10);
		 for (int i = 0; i < 10; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {

						try {
							System.out.println(Thread.currentThread().getName());
							barrier.await();
						
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				
				}
			});
		}
		 service.shutdown();
	}

}
