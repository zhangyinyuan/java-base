package com.yuan.ngu.java.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定长线程池，可以控制线程的最大数，超出的线程会在队列中等待
 */
@Slf4j
public class NewFixedThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
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
