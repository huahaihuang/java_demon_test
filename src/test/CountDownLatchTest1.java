package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest1 {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		final CountDownLatch latch = new CountDownLatch(2);
		for (int i = 0; i < 2; i++) {
			service.submit(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
						Thread.sleep(3000);
						System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
						
						latch.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			});
		}
		
		try {
			System.out.println("等待2个子线程执行完毕...");
			latch.await();
			System.out.println("2个子线程已经执行完毕");
			System.out.println("继续执行主线程");
			service.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
  /*  List<String> days = MyDateUtils.getDays(requestParams.getStartTime(), requestParams.getEndTime());        
    // 天数长度
    int length = days.size();        
    // 初始化合并集合，并指定大小，防止数组越界
    List<你想要的数据类型> list = Lists.newArrayListWithCapacity(length);        
    // 初始化线程池
    ExecutorService pool = Executors.newFixedThreadPool(length);                   // 初始化计数器
    CountDownLatch latch = new CountDownLatch(length);        
    // 查询每天的时间并合并
    for (String day : days) {            Map<String, Object> param = Maps.newHashMap();            
    // param 组装查询条件

        pool.submit(new Runnable() {
            @Override
            public void run() {                    
                 try {                                     
                      // mybatis查询sql
                      // 将结果汇总
                    list.addAll(查询结果);
                } catch (Exception e) {
                    logger.error("getTime异常", e);
                } finally {
                    latch.countDown();
                }
            }
        });
    }       
                      
   try {            
       // 等待所有查询结束
       latch.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }      */  
        
    // list为汇总集合
    // 如果有必要，可以组装下你想要的业务数据，计算什么的，如果没有就没了
    

}
