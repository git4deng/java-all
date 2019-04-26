package com.david.basic.thread.threadCorresponded;

/**
 * 生产者(包子铺)类:是一个线程类,可以继承Thread
 设置线程任务(run):生产包子
 对包子的状态进行判断
 true:有包子
 包子铺调用wait方法进入等待状态
 false:没有包子
 包子铺生产包子
 增加一些趣味性:交替生产两种包子
 有两种状态(i%2==0)
 包子铺生产好了包子
 修改包子的状态为true有
 唤醒吃货线程,让吃货线程吃包子

 注意:
 包子铺线程和包子线程关系-->通信(互斥)
 必须同时同步技术保证两个线程只能有一个在执行
 锁对象必须保证唯一,可以使用包子对象作为锁对象
 包子铺类和吃货的类就需要把包子对象作为参数传递进来
 1.需要在成员位置创建一个包子变量
 2.使用带参数构造方法,为这个包子变量赋值
 * @author david
 * @create 2019-04-18 23:47
 */
public class BunShop extends Thread{
    private Bun bun;

    public BunShop(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {
        int n=0;
        while (true){
            synchronized (bun){
                if(bun.isFlag()){
                    try {
                        bun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(n%2==0){
                    bun.setSkin("薄皮");
                    bun.setXian("三鲜馅");
                }else{
                    bun.setSkin("冰皮");
                    bun.setXian("牛肉大葱陷");
                }
                n++;
                System.out.println("包子铺子正在生产包子："+bun);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bun.setFlag(true);

                bun.notify();
                System.out.println("包子铺子生产了包子："+bun+",这是第"+n+"个！");
            }
        }


    }
}
