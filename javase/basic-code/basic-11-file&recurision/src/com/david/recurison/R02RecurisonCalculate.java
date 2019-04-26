package com.david.recurison;

import java.io.File;

/**
 * 使用递归计算1-n之间的和
 * @author david
 * @create 2019-04-20 17:25
 */
public class R02RecurisonCalculate {
    static int i=0;
    public static void main(String[] args) {
        int result=sum(100);
        System.out.println(result);

        int jc = jc(5);
        System.out.println(jc);

        File dir=new File("D:\\BaiduNetdiskDownload");
        getAllFiles(dir);
        System.out.println(i);
    }

    private static void getAllFiles(File dir) {
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                getAllFiles(file);
            }else {
                System.out.println(file);
            }
        }
        i++;
    }

    /**
        定义方法使用递归计算阶乘
        5的阶乘: 5! = 5*(5-1)*(5-2)*(5-3)*(5-4)=5*4*3*2*1
        递归结束的条件
            获取到1的时候结束
        递归的目的
            获取下一个被乘的数字(n-1)
        方法的参数发生变化
            5,4,3,2,1
     */
    private static int jc(int i) {
        if(i==1){
            return 1;
        }
        return i*jc(i-1);
    }

    private static int sum(int i) {
        System.out.println("当前值："+i);
        if(i==1) return 1;

        return i+sum(i-1);

    }


}
