package com.david.jdk8new.methodReference;

/**
 * @author david
 * @create 2019-04-27 22:56
 */
public class M04SuperMethodReference extends Human{
    //子类重写父类sayHello的方法
    @Override
    public void sayHello() {
        System.out.println("Hello 我是Man!");
    }

    //定义一个方法参数传递Greetable接口
    public void method(Greetable g){
        g.greet();
    }

    public void show(){
        //调用method方法,方法的参数Greetable是一个函数式接口,所以可以传递Lambda
        /*method(()->{
            //创建父类Human对象
            Human h = new Human();
            //调用父类的sayHello方法
            h.sayHello();
        });*/

        //因为有子父类关系,所以存在的一个关键字super,代表父类,所以我们可以直接使用super调用父类的成员方法
       /* method(()->{
            super.sayHello();
        });*/

      /*
           使用super引用类的成员方法
           super是已经存在的
           父类的成员方法sayHello也是已经存在的
           所以我们可以直接使用super引用父类的成员方法
       */
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new M04SuperMethodReference().show();
        new M04SuperMethodReference().method(new M04SuperMethodReference()::sayHello);
    }

}

/**
 * 定义见面的函数式接口
 */
@FunctionalInterface
interface Greetable{
    //定义一个见面的方法
    void greet();
}
class Human{
    //定义一个sayHello的方法
    public void sayHello(){
        System.out.println("Hello 我是Human!");
    }
}

