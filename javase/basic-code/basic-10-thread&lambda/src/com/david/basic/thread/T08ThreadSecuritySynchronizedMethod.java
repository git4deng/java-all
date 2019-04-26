package com.david.basic.thread;

/**
 * @author david
 * @create 2019-04-18 20:56
 */
public class T08ThreadSecuritySynchronizedMethod {
    public static void main(String[] args) {
        TicketThreadM ticket = new TicketThreadM();
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
 卖票案例出现了线程安全问题
 卖出了不存在的票和重复的票

 解决线程安全问题的二种方案:使用同步方法
 使用步骤:
 1.把访问了共享数据的代码抽取出来,放到一个方法中
 2.在方法上添加synchronized修饰符

 格式:定义方法的格式
 修饰符 synchronized 返回值类型 方法名(参数列表){
 可能会出现线程安全问题的代码(访问了共享数据的代码)
 */
class TicketThreadM implements Runnable{
    int ticket=100;
    static int ticket2=100;
    @Override
    public void run() {
          //  saleTicket();
        payTicketStatic();
    }
    public synchronized void saleTicket(){
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票！");
                --ticket;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "票已卖完！");
                return;
            }
        }
    }
    /*
        静态的同步方法
        锁对象是谁?
        不能是this
        this是创建对象之后产生的,静态方法优先于对象
        静态方法的锁对象是本类的class属性-->class文件对象(反射)
     */
    public static /*synchronized*/ void payTicketStatic(){
        synchronized (TicketThreadM.class){
            //先判断票是否存在
            while (true) {
                if (ticket2 > 0) {
                    //提高安全问题出现的概率,让程序睡眠
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //票存在,卖票 ticket--
                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket2 + "张票");
                    ticket2--;
                }
            }
        }

    }
}