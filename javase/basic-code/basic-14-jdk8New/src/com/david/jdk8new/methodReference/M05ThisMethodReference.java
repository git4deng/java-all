package com.david.jdk8new.methodReference;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author david
 * @create 2019-04-27 23:29
 */
public class M05ThisMethodReference {
    public void method(Richable r){
        r.buy();
    }
    public  void buyHouse(){
        System.out.println("成都绕城外买一个小house！");
    }

    /**
     * lambda方式
     */
    public void soHappy(){
        method(()->this.buyHouse());
    }
    /*
        使用方法引用优化Lambda表达式
        this是已经存在的
        本类的成员方法buyHouse也是已经存在的
        所以我们可以直接使用this引用本类的成员方法buyHouse
     */
    public void soHapppy(){
        method(this::buyHouse);
    }
    public static void main(String[] args) {
        new M05ThisMethodReference().soHappy();
        new M05ThisMethodReference().soHapppy();
    }
}
@FunctionalInterface
interface Richable{
    void buy();
}