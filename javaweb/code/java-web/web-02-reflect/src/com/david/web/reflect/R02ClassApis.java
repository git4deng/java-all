package com.david.web.reflect;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Class对象功能：
 * 获取功能：
 1. 获取成员变量们
 * Field[] getFields()
 * Field getField(String name)  获取指定名称的 public修饰的成员变量

 * Field[] getDeclaredFields()
 * Field getDeclaredField(String name)
 2. 获取构造方法们
 * Constructor<?>[] getConstructors()
 * Constructor<T> getConstructor(类<?>... parameterTypes)

 * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 * Constructor<?>[] getDeclaredConstructors()
 3. 获取成员方法们：
 * Method[] getMethods()
 * Method getMethod(String name, 类<?>... parameterTypes)

 * Method[] getDeclaredMethods()
 * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

 4. 获取类名
 * String getName()
 * @author david
 * @create 2019-04-28 22:03
 */
public class R02ClassApis {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        System.out.println("==============获取成员变量们==========");
        getFieldsMethod();
        System.out.println("---------分割符-------------");
        getDeclaredFieldMethod();

        System.out.println("==============获取构造方法们==========");
        getConstructorsMethod();

        System.out.println("==============获取成员方法们==========");
        getMethodsMethod();
        System.out.println("==============获取类名==========");
        getClassNameMethod();
    }

    /**
     * 4. 获取类名
     * String getName()
     */
    private static void getClassNameMethod() {
        Class scls = Student.class;
        String name = scls.getName();
        System.out.println(name);
    }

    /**
     * 3. 获取成员方法们：
     * Method[] getMethods()
     * Method getMethod(String name, 类<?>... parameterTypes)
     */
    private static void getMethodsMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class scls = Student.class;
        //获取指定名称的方法，无参数的方法
        Method learn = scls.getMethod("learn");
        //通过无参构造器获取一个对象
        Object o = scls.newInstance();
        //执行该对象的方法，invoke方法需要传入对象
        learn.invoke(o);

        System.out.println("--------------分割符-------------");
        //获取一个带参的方法
        Method method2 = scls.getMethod("learn",String.class);
        //执行方法，传入对象和参数
        method2.invoke(o,"Java");
        System.out.println("--------------分割符-------------");
        //获取所有public修饰的方法
        Method[] methods = scls.getMethods();
        Stream.of(methods).forEach(System.out::println);
        //获取所有方法，不考虑修饰符
        Method[] dms = scls.getDeclaredMethods();
        Stream.of(dms).forEach(System.out::println);

    }

    /**
     * 2. 获取构造方法们
     * Constructor<?>[] getConstructors()
     * Constructor<T> getConstructor(类<?>... parameterTypes)
     */
    private static void getConstructorsMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class scls = Student.class;
        Constructor con1 = scls.getConstructor(String.class, int.class);//此处用Integer.class要报错NoSuchMethodException
        Object stu = con1.newInstance("David", 25);
        System.out.println(stu);
        System.out.println("--------------分割符-----------");
        Constructor con2 = scls.getConstructor();//获取无参构造器
        Object stu2 = con2.newInstance();
        System.out.println(stu2);

        //Class包含一个直接调用无参构造器创建对象的方法
        Object stu3 = scls.newInstance();
        System.out.println(stu3);
        Constructor[] csts = scls.getConstructors();
        //使用lambda表达式遍历并使用方法引用的方式优化lambda表达式
        Stream.of(csts).forEach(System.out::println);

        System.out.println("---------------分割符----------------");
        //也可以获取所有的构造器，不考虑修饰符
        Constructor[] dcs = scls.getDeclaredConstructors();
        Stream.of(dcs).forEach((d)->{
            d.setAccessible(true);
            Parameter[] parameters = d.getParameters();
            Stream.of(parameters).forEach(System.out::println);
        });


    }

    /**
     * Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
     * Field getDeclaredField(String name) 获取指定名称的成员变量，不考虑修饰符
     */
    private static void getDeclaredFieldMethod() throws NoSuchFieldException, IllegalAccessException {
        Class scls = Student.class;
        Field[] declaredFields = scls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        Field name = scls.getDeclaredField("name");
        Student s=new Student();

        //java.lang.IllegalAccessException: Class com.david.web.reflect.R02ClassApis can not access a member of class
        name.setAccessible(true);//忽略访问权限修饰符的安全检查,即暴力反射，如果不设置就会抛出异常
        name.set(s,"david");
        System.out.println(name.get(s));
        System.out.println(s);

    }

    /**
     * 获取成员变量们
     * Field[] getFields() 获取所有public修饰的成员变量
     * Field getField(String name) 获取指定名称的 public修饰的成员变量
     */
    private static void getFieldsMethod() throws NoSuchFieldException, IllegalAccessException {
        Class scls = Student.class;
        //获取public修饰的成员变量
        Field[] fields = scls.getFields();
        Stream<Field> stream =Stream.of(fields);
        stream.forEach(f->{
            System.out.println(f.getName());//获取变量的名字
            System.out.println(f.getType());//获取变量类型
        });
        System.out.println(scls.getField("email"));
        Field email = scls.getField("email");
        Student s=new Student();
        //给成员变量设置值，需要传入对象
        email.set(s,"123456");
        //获取该变量的值，需要传入对象
        Object o = email.get(s);
        System.out.println("value:"+o);
    }


}
class Student{
    private String name;
    private int age;
    public String email;
    public String classId;

    protected String p;
    String d;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", classId='" + classId + '\'' +
                ", p='" + p + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public Student() {

    }

    public void learn(){
        System.out.println("i'm learning.......");
    }
    public void learn(String s){
        System.out.println("i'm learning......."+s);
    }
    private void dowork(){
        System.out.println("private method!");
    }
}