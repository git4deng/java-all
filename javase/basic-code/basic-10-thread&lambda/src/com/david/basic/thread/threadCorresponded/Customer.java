package com.david.basic.thread.threadCorresponded;

/**
 *
 消费者(吃货)类:是一个线程类,可以继承Thread
 设置线程任务(run):吃包子
 对包子的状态进行判断
 false:没有包子
 吃货调用wait方法进入等待状态
 true:有包子
 吃货吃包子
 吃货吃完包子
 修改包子的状态为false没有
 吃货唤醒包子铺线程,生产包子
 * @author david
 * @create 2019-04-18 23:58
 */
public class Customer extends Thread{
    private Bun bun;

    public Customer(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bun){
                if(!bun.isFlag()){
                    try {
                        bun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("顾客正在吃包子："+bun);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("顾客吃完了包子哟。。");
                bun.setFlag(false);
                bun.notify();
            }
        }
    }
}
