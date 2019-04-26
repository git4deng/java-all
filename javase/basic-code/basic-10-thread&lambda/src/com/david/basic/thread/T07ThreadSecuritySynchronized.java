package com.david.basic.thread;

/**
 * @author david
 * @create 2019-04-18 20:56
 */
public class T07ThreadSecuritySynchronized {
    public static void main(String[] args) {
        TicketThread ticket = new TicketThread();
        Thread t1 = new Thread(ticket);
        t1.setName("窗口1");
        t1.start();
        Thread t2 = new Thread(ticket);
        t2.setName("窗口2");
        t2.start();
        Thread t3 = new Thread(ticket);
        t3.setName("窗口3");
        t3.start();
        /*
        不加锁的情况下会出现以下情况：
        窗口1正在卖第100张票！
        窗口2正在卖第100张票！
        窗口3正在卖第100张票！
         */
    }
}

/**
 *
 卖票案例出现了线程安全问题
 卖出了不存在的票和重复的票

 解决线程安全问题的一种方案:使用同步代码块
 格式:
 synchronized(锁对象){
 可能会出现线程安全问题的代码(访问了共享数据的代码)
 }

 注意:
 1.通过代码块中的锁对象,可以使用任意的对象
 2.但是必须保证多个线程使用的锁对象是同一个
 3.锁对象作用:
 把同步代码块锁住,只让一个线程在同步代码块中执行
 */
class TicketThread implements Runnable{
    int ticket=100;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票！");
                    --ticket;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName()+"票已卖完！");
                    return;
                }
            }
        }
    }
}