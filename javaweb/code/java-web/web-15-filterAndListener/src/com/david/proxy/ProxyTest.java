package com.david.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象测试
 * @author david
 * @create 2019-06-08 21:55
 */
public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        SaleComputer lenovo=new Lenovo();
        //2.动态代理增强lenovo对象
        /*
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */
        SaleComputer proxy = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
                代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                    参数：
                        1. proxy:代理对象
                        2. method：代理对象调用的方法，被封装为的对象
                        3. args:代理对象调用的方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sale")) {
                    double menoy = (double) args[0];
                    menoy = menoy * 0.85;//修改传入参数
                    String invoke = (String) method.invoke(lenovo, menoy);
                    invoke = invoke + "_代理标识";
                    return invoke;
                } else {
                    //其它方法直接原样返回
                    return method.invoke(lenovo, args);
                }
            }
        });

        String sale = proxy.sale(8000.00);
        System.out.println(sale);

    }


}
