package com.david.basic.thread;

/**
 * @author david
 * @create 2019-04-18 20:56
 */
public class T06ThreadSecurity {
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

class ticketThread implements Runnable{
    int ticket=100;
    @Override
    public void run() {
        while (true){
            if(ticket>0){

                System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票！");
                --ticket;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("票已卖完！");
                return;
            }
        }
    }
}