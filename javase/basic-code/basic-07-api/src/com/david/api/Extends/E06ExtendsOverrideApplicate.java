package com.david.api.Extends;

/**
 * 重载方法，优先使用子类重载方法，若成员变量含有重名的，等号左边的是谁就是谁的，子类没有可以向上去父类找
 * 父类没有的不能向下去子类找。
 * @author david
 * @create 2019-04-11 21:44
 */
public class E06ExtendsOverrideApplicate {
    public static void main(String[] args) {
        OldPhone op=new OldPhone();
        op.show();
        System.out.println("-----------");
        NewPhone np=new NewPhone();
        np.show();
        System.out.println("-----------");
        OldPhone op1=new NewPhone();//重载方法还是优先子类
        op1.show();


    }
}
class OldPhone{
    public void call(){
        System.out.println("打电话。。。");
    }
    public  void sendMessage(){
        System.out.println("发送信息。。");
    }
    public void show(){
        System.out.println("显示号码。。。");
    }
}
class NewPhone extends OldPhone{
    @Override
    public void show() {
        super.show();
        System.out.println("显示姓名。。");
        System.out.println("显示头像。。");
    }
}