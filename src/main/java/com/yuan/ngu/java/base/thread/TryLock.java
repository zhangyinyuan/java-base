package com.yuan.ngu.java.base.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁的解决方法,就是使用 tryLock ,设置持有锁的最大时间
 */
public class TryLock {
    static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread001 = new Thread(new DeadLock.MyRunnable(true), "线程001");
        Thread thread002 = new Thread(new DeadLock.MyRunnable(false), "线程002");
        thread001.start();
        thread002.start();
    }

    static class MyRunnable implements Runnable {
        private static Object object0001 = new Object();
        private static Object object0002 = new Object();

        private boolean flag;

        public MyRunnable(boolean flag) {
            this.flag = flag;
        }

        public void run() {
            if (flag) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 获取到object0001对象锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "准备获取object0002对象锁");
                synchronized (object0002) {
                    System.out.println(Thread.currentThread().getName() + " 获取到object0002对象锁");
                }
                lock.unlock();
            } else {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 获取到object0002对象锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "准备获取object0001对象锁");
                synchronized (object0001) {
                    System.out.println(Thread.currentThread().getName() + " 获取到object0001对象锁");
                }
                lock.unlock();
            }
        }
    }
}

