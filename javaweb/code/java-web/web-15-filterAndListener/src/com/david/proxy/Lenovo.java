package com.david.proxy;

/**
 * @author david
 * @create 2019-06-08 21:54
 */
public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("消费了"+money+"元购买了一台联想电脑！");
        return "电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑....");
    }
}
