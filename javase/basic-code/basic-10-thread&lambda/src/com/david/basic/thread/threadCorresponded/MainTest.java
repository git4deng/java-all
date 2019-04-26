package com.david.basic.thread.threadCorresponded;

/**
 * @author david
 * @create 2019-04-19 0:02
 */
public class MainTest {
    public static void main(String[] args) {
        Bun bun=new Bun();
        new BunShop(bun).start();
        new Customer(bun).start();
    }
}
