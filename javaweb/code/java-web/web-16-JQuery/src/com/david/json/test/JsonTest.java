package com.david.json.test;

import com.david.json.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author david
 * @create 2019-06-11 21:32
 */
public class JsonTest {
    private Person person=null;
    private ObjectMapper om=null;
    @Before
    public void init(){
        person=new Person();
        person.setName("David");
        person.setAge(21);
        person.setGender("男");
        person.setBirthday(new Date());
        om=new ObjectMapper();
    }

    /**
     * ObjectMapper对象转换的常用方法
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        //创建Jackson的核心对象 ObjectMapper



        /*
            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串
         */
        String p = om.writeValueAsString(person);
        System.out.println(p);

        //writeValue，将数据写到d://a.txt文件中
        //om.writeValue(new File("d://a.txt"),person);

        //writeValue.将数据关联到Writer中
       // om.writeValue(new FileWriter("d://b.txt"),person);
    }

    /**
     *  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 格式化注解
     *  @JsonIgnore 注解json转换忽略该属性
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        String s = om.writeValueAsString(person);
        System.out.println(s);//{"name":"David","age":21,"gender":"男","birthday":"2019-06-11 13:56:12"}
    }

    /**
     * List集合转换
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        List<Person> ps=new ArrayList<>();

        ps.add(person);
        ps.add(person);
        ps.add(person);
        ps.add(person);

        String ls = om.writeValueAsString(ps);
        /*
        [{"name":"David","age":21,"gender":"男","birthday":"2019-06-11 14:00:00"},{"name":"David","age":21,"gender":"男",
        "birthday":"2019-06-11 14:00:00"},{"name":"David","age":21,"gender":"男","birthday":"2019-06-11 14:00:00"},{"name":
        "David","age":21,"gender":"男","birthday":"2019-06-11 14:00:00"}]
         */
        System.out.println(ls);

    }

    /**
     * Map集合转换
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");
        String s = om.writeValueAsString(map);
        System.out.println(s);//{"gender":"男","name":"张三","age":23}

    }
    //演示 JSON字符串转为Java对象
    @Test
    public void test5() throws Exception {
        //1.初始化JSON字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //3转换为Java对象 Person对象
        Person person = om.readValue(json, Person.class);
        System.out.println(person);
    }
}
