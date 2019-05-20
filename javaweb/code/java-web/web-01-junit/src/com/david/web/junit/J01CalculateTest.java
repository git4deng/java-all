package com.david.web.junit;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.ScreenUpdateManager;

/**
 * @author david
 * @create 2019-04-28 20:29
 */
public class J01CalculateTest {
    public static void main(String[] args) {
        Calculator c=new Calculator();
        int sum = c.sum(1,2);
        System.out.println("sum:"+sum);
    }

    /**
     * 初始化方法：
     *  用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("初始化方法..........");
    }

    /**
     * 释放资源方法：
     *  在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void destroy(){
        System.out.println("销毁方法.........");
    }
    @Test
    public void testSum(){
        Calculator c=new Calculator();
        int sum = c.sum(1,2);
        System.out.println("sum:"+sum);
        //断言结果为2，如果结果不为3将抛出如下异常
        //java.lang.AssertionError:
        //Expected :2
        //Actual   :3
        Assert.assertEquals(2, sum);
    }
}
class Calculator{
    public int sum(int a,int b){
        return a+b;
    }
    public int sub(int a,int b){
        return a-b;
    }
}