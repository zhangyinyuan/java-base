package com.yuan.ngu.java.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存的线程池。比较灵活，没有可用线程的时候，则创建新的线程；有空闲的线程的时候则复用；线程数多于需求数的时候则回收多于的线程
 * 不能控制线程的最大数目
 * <p>
 * <p>
 * 如：线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 */
@Slf4j
public class NewCachedThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
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
