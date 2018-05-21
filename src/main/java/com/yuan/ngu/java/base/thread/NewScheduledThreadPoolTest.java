package com.yuan.ngu.java.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 支持周期性任务和定时任务
 */
@Slf4j
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        log.debug("开始执行");
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.debug("延迟2秒执行，只执行一次");
            }
        }, 2, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("隔0秒后，每3秒执行一次");
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    // TODO: 2018年3月14日 0014  定时任务未实现

}