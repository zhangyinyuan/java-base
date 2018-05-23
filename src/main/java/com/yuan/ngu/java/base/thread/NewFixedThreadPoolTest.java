package com.yuan.ngu.java.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定长线程池，可以控制线程的最大数，超出的线程会在队列中等待
 * 优点是:可控制线程池的大小,因为不受限制的创建更多的线程开销反而更大
 * 缺点是:当需求数大于线程池的数量的时候,那些多出来的需求线程需要等待,知道有空闲线程才执行
 */
@Slf4j
// [fɪkst]
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.debug("i = {}", finalI);
                }
            });
        }
    }
}
