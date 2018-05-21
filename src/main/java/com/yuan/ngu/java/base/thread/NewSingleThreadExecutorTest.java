package com.yuan.ngu.java.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单一线程池
 * <p>
 * 保证所有的任务都是顺序执行的
 */
@Slf4j
public class NewSingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        while (true){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                }
            });
        }
    }
}
