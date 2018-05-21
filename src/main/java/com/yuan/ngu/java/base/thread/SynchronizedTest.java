package com.yuan.ngu.java.base.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Synchronized 测试类
 *
 * @author zhangyinyuan
 * @create 2018-05-21 18:08
 **/
@Slf4j
public class SynchronizedTest {


    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new MyThread().start();
        }
        Thread.sleep(5000);
    }


    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            new Syn().test();
        }
    }

    static class Syn {
        //        public synchronized void test() {
//            log.debug(Thread.currentThread().getName() + "同步开始");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.debug(Thread.currentThread().getName() + "同步结束");
//        }
//        public void test() {
//            synchronized (this) {
//                log.debug(Thread.currentThread().getName() + "同步开始");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                log.debug(Thread.currentThread().getName() + "同步结束");
//            }
//        }
//        实现了同步
//        public void test() {
//            synchronized (Syn.class) {
//                log.debug(Thread.currentThread().getName() + "同步开始");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                log.debug(Thread.currentThread().getName() + "同步结束");
//            }
//        }

        //实现了同步
//        public static synchronized void test() {
//            log.debug(Thread.currentThread().getName() + "同步开始");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.debug(Thread.currentThread().getName() + "同步结束");
//        }

        static byte[] arr = new byte[0];

        //        实现了同步
        public void test() {
            synchronized (arr) {
                log.debug(Thread.currentThread().getName() + "同步开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug(Thread.currentThread().getName() + "同步结束");
            }
        }
    }
}
