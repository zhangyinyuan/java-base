package com.yuan.ngu.java.base.thread;

/**
 * 死锁
 * 概念:多个线程以不同的顺序访问共享资源,在自己线程的对象锁里面又要获取其他线程的对象锁，
 * 导致两个线程都无法获取到彼此持有的对象锁,多个线程进入无限等待的这个现象,叫做死锁
 * 如何防止死锁?
 * 1. 尽量不要获取双重锁,而是等待锁释放对象后再获取新的锁,换句话说,如果可以,一个线程尽量最多获取一个锁
 * 2. 死锁是无限等待的对方释放锁这样一个过程,那么创建锁的时候可以加一个超时时间,
 * 如果持有锁的时间超过了设置的最大时间,则释放锁,可以使用Lock类的tryLock.
 */
public class DeadLock {

    public static void main(String[] args) {
        Thread thread001 = new Thread(new MyRunnable(true), "线程001");
        Thread thread002 = new Thread(new MyRunnable(false), "线程002");
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
                synchronized (object0001) {
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
                }
            } else {
                synchronized (object0002) {
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
                }
            }
        }
    }
}
