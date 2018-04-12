package com.mmall.concurrency;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

/**
 * @project: concurrency
 * @description: 测试类
 * @author: Yuanjk
 * @create: 2018-04-13 01:15:28
 **/
@NotThreadSafe
@Slf4j
public class ConcurrencyTest {
//    请求总数
    public static int clientTotal = 5000;
//    同时并发执行的线程数
    public static  int  threadTotal = 50;

    public  static  int count = 0;

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e){
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }

    public static void add(){

        count ++;
    }
}
