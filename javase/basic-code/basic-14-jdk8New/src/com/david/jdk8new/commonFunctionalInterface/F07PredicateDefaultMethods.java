package com.david.jdk8new.commonFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 逻辑表达式:可以连接多个判断的条件
 &&:与运算符,有false则false
 ||:或运算符,有true则true
 !:非(取反)运算符,非真则假,非假则真
 * @author david
 * @create 2019-04-26 23:17
 */
public class F07PredicateDefaultMethods {

    public static void main(String[] args) {
        String str="david";
        boolean b=andMethod(str,(s)->{
            return s.length()>5;
        },(s)->{
           return s.contains("a");
        });
        System.out.println(b);
        b=orMethod(str,(s)->{
            return s.length()>5;
        },(s)->{
            return s.contains("a");
        });
        System.out.println(b);
        b=negateMethod(str,(s)->s.length()>5);
        System.out.println(b);

        System.out.println("---------------练习：集合信息筛选----------------");
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        List<String> strings = UsePredicateDefualtMethods(array, (s) -> s.split(",")[0].length() == 4,
                (s) -> "女".equals(s.split(",")[1]));
        System.out.println(strings);
    }

    /**
     * 需求:判断一个字符串,有两个判断的条件
     1.判断字符串的长度是否大于5
     2.判断字符串中是否包含a
     两个条件必须同时满足,我们就可以使用&&运算符连接两个条件

     Predicate接口中有一个方法and,表示并且关系,也可以用于连接两个判断条件
     default Predicate<T> and(Predicate<? super T> other) {
     Objects.requireNonNull(other);
     return (t) -> this.test(t) && other.test(t);
     }
     方法内部的两个判断条件,也是使用&&运算符连接起来的
     * @param s
     * @param p1
     * @param p2
     * @return
     */
    public static boolean andMethod(String s, Predicate<String> p1,Predicate<String> p2){
       // return p1.test(s) && p2.test(s);
        return p1.and(p2).test(s);
    }

    /**
     * 需求:判断一个字符串,有两个判断的条件
     1.判断字符串的长度是否大于5
     2.判断字符串中是否包含a
     满足一个条件即可,我们就可以使用||运算符连接两个条件

     Predicate接口中有一个方法or,表示或者关系,也可以用于连接两个判断条件
     default Predicate<T> or(Predicate<? super T> other) {
     Objects.requireNonNull(other);
     return (t) -> test(t) || other.test(t);
     }
     方法内部的两个判断条件,也是使用||运算符连接起来的
     * @param s
     * @param p1
     * @param p2
     * @return
     */
    public static boolean orMethod(String s, Predicate<String> p1,Predicate<String> p2){
        return p1.or(p2).test(s);
    }

    /**
     * 需求:判断一个字符串长度是否大于5
     如果字符串的长度大于5,那返回false
     如果字符串的长度不大于5,那么返回true
     所以我们可以使用取反符号!对判断的结果进行取反

     Predicate接口中有一个方法negate,也表示取反的意思
     default Predicate<T> negate() {
     return (t) -> !test(t);
     }
     */
    public static boolean negateMethod(String s, Predicate<String> p1){
        return p1.negate().test(s);
    }

    /**
     * 练习：集合信息筛选
     数组当中有多条“姓名+性别”的信息如下，
     String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
     请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，
     需要同时满足两个条件：
     1. 必须为女生；
     2. 姓名为4个字。

     分析:
     1.有两个判断条件,所以需要使用两个Predicate接口,对条件进行判断
     2.必须同时满足两个条件,所以可以使用and方法连接两个判断条件
     * @param arr
     * @param p1
     * @param p2
     * @return
     */
    public static List<String> UsePredicateDefualtMethods(String[] arr,Predicate<String> p1,Predicate<String> p2){
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean b = p1.and(p2).test(s);
            if(b) list.add(s);
        }
        return list;
    }
}
