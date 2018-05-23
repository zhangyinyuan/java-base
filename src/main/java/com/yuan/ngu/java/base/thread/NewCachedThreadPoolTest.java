package com.yuan.ngu.java.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存的线程池。没有可用线程的时候，则创建新的线程；有空闲的线程的时候则复用；线程数多余需求数的时候则回收多余的线程
 * 优点:比较灵活,有空闲线程则复用,没有的时候则创建
 * 缺点:不能控制线程的最大数目(线程池内线程数目为无限大)
 */
@Slf4j
//[kæʃ] [puːl]
public class NewCachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000000; i++) {
            final int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.debug("i = {}", finalI);
                }
            });
        }
    }
}
