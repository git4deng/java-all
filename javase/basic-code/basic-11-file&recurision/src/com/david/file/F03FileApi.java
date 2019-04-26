package com.david.file;

import java.io.File;
import java.io.IOException;

/**
 * File的常用API
 * File类获取功能的方法
 - public String getAbsolutePath() ：返回此File的绝对路径名字符串。
 - public String getPath() ：将此File转换为路径名字符串。
 - public String getName()  ：返回由此File表示的文件或目录的名称。
 - public long length()  ：返回由此File表示的文件的长度。
 File类判断功能的方法
 - public boolean exists() ：此File表示的文件或目录是否实际存在。
 - public boolean isDirectory() ：此File表示的是否为目录。
 - public boolean isFile() ：此File表示的是否为文件。

 File类创建删除功能的方法
 - public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
 - public boolean delete() ：删除由此File表示的文件或目录。
 - public boolean mkdir() ：创建由此File表示的目录。
 - public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。

 File类遍历(文件夹)目录功能
 - public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
 - public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。

 注意:
 list方法和listFiles方法遍历的是构造方法中给出的目录
 如果构造方法中给出的目录的路径不存在,会抛出空指针异常
 如果构造方法中给出的路径不是一个目录,也会抛出空指针异常
 * @author david
 * @create 2019-04-20 15:02
 */
public class F03FileApi {
    public static void main(String[] args) {
        System.out.println("===============File获取功能方法===============");

        System.out.println("-----File的getAbsolutePath方法-----");
        getAbsolutePathMethod();

        System.out.println("-----File的getPath方法-----");
        getPathMethod();

        System.out.println("-----File的getName方法-----");
        getNameMethod();

        System.out.println("-----File的length方法-----");
        lengthMethod();
        System.out.println("===============File判断方法==============");
        System.out.println("-----exists方法-----");
        existsMethod();

        System.out.println("-----isDirectory方法-----");
        isDirectoryMethod();

        System.out.println("===============File类创建删除功能的方法==============");

        System.out.println("-----createNewFile方法-----");
        createNewFileMethod();

        System.out.println("-----mkdirs方法-----");
        mkdirsMethod();
        System.out.println("-----delete方法-----");
        deleteMethod();

        System.out.println("===============File类遍历(文件夹)目录功能==============");
        System.out.println("-----list方法-----");
        listMetod();

        System.out.println("-----listFiles方法-----");
        listFilesMetod();
    }
    /**
        public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
        遍历构造方法中给出的目录,会获取目录中所有的文件/文件夹,把文件/文件夹封装为File对象,多个File对象存储到File数组中
     */
    private static void listFilesMetod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code\\basic-11-file";
        File f1=new File(path);
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

    /**
     *
         public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
         遍历构造方法中给出的目录,会获取目录中所有文件/文件夹的名称,把获取到的多个名称存储到一个String类型的数组中
     */
    private static void listMetod() {
      String path = "F:\\learn\\java-all\\javase\\basic-code\\basic-11-file";
       // String path = "F:\\learn\\java-all\\javase\\basic-code\\basic-11-file1";//java.lang.NullPointerException
       // String path = "F:\\learn\\java-all\\javase\\basic-code\\basic-11-file\\a.txt";//java.lang.NullPointerException
        File f1=new File(path);
        String[] list = f1.list();
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * public boolean delete() ：删除由此File表示的文件或目录。
     此方法,可以删除构造方法路径中给出的文件/文件夹
     返回值:布尔值
     true:文件/文件夹删除成功,返回true
     false:文件夹中有内容,不会删除返回false;构造方法中路径不存在false
     注意:
     delete方法是直接在硬盘删除文件/文件夹,不走回收站,删除要谨慎
     */
    private static void deleteMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code\\basic-11-file";
        File f1=new File(path,"新建文件夹1");
        boolean b = f1.delete();
        System.out.println(b);
        File f3=new File(path,"aaa\\bbb\\ccc\\ddd");
        boolean delete = f3.delete();
        System.out.println(delete);
    }

    /**
       public boolean mkdir() ：创建单级空文件夹
       public boolean mkdirs() ：既可以创建单级空文件夹,也可以创建多级文件夹
       创建文件夹的路径和名称在构造方法中给出(构造方法的参数)
        返回值:布尔值
            true:文件夹不存在,创建文件夹,返回true
            false:文件夹存在,不会创建,返回false;构造方法中给出的路径不存在返回false
        注意:
            1.此方法只能创建文件夹,不能创建文件
     */
    private static void mkdirsMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code\\basic-11-file";
        File f1=new File(path,"新建文件夹1");
        boolean b = f1.mkdir();
        System.out.println(b);

        File f2=new File("basic-11-file\\新建文件2");
        b = f2.mkdir();
        System.out.println(b);

        File f3=new File(path,"aaa\\bbb\\ccc\\ddd");
        b = f3.mkdir();
        System.out.println(b);
        b = f3.mkdirs();
        System.out.println(b);
    }

    /**
     * public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
     创建文件的路径和名称在构造方法中给出(构造方法的参数)
     返回值:布尔值
     true:文件不存在,创建文件,返回true
     false:文件存在,不会创建,返回false
     注意:
     1.此方法只能创建文件,不能创建文件夹
     2.创建文件的路径必须存在,否则会抛出异常

     public boolean createNewFile() throws IOException
     createNewFile声明抛出了IOException,我们调用这个方法,就必须的处理这个异常,要么throws,要么trycatch
     */
    private static void createNewFileMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code\\basic-11-file\\a.txt";
        //绝对路径
        File f1=new File(path);
        try {
            boolean b = f1.createNewFile();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //相对路径
        File f2=new File("b.txt");
        try {
            boolean b = f2.createNewFile();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
         public boolean isDirectory() ：此File表示的是否为目录。
         用于判断构造方法中给定的路径是否以文件夹结尾
         是:true
         否:false
         public boolean isFile() ：此File表示的是否为文件。
         用于判断构造方法中给定的路径是否以文件结尾
         是:true
         否:false
         注意:
         电脑的硬盘中只有文件/文件夹,两个方法是互斥
         这两个方法使用前提,路径必须是存在的,否则都返回false

     */
    private static void isDirectoryMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code";
        File f1=new File(path);
        //不存在,就没有必要获取
        if(f1.exists()){
            boolean directory = f1.isDirectory();
            boolean file = f1.isFile();
            System.out.println("f1:isDirectory:"+directory+",isFile:"+file);
        }

        File f2=new File(".idea\\workspace.xml");//相对路径，相对当前项目的根目录
        if(f2.exists()){
            boolean directory = f2.isDirectory();
            boolean file = f2.isFile();
            System.out.println("f2:isDirectory:"+directory+",isFile:"+file);
        }
    }

    /**
     * public boolean exists() ：此File表示的文件或目录是否实际存在。
         用于判断构造方法中的路径是否存在
         存在:true
         不存在:false
     */
    private static void existsMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code";
        File f1=new File(path);
        System.out.println(f1.exists());
        File f2=new File("a.txt");//相对路径，相对当前项目的根目录
        System.out.println(f2.exists());
    }

    /**
        public long length()  ：返回由此File表示的文件的长度。
        获取的是构造方法指定的文件的大小,以字节为单位
        注意:
            文件夹是没有大小概念的,不能获取文件夹的大小
            如果构造方法中给出的路径不存在,那么length方法返回0
     */
    private static void lengthMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code";
        File f1=new File(path);
        System.out.println(f1.length());
        File f2=new File("a.txt");//相对路径，相对当前项目的根目录
        System.out.println(f2.length());
    }

    /**
     *  public String getName()  ：返回由此File表示的文件或目录的名称。
        获取的就是构造方法传递路径的结尾部分(文件/文件夹)
     */
    private static void getNameMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code";
        File f1=new File(path);
        System.out.println(f1.getName());
        File f2=new File("a.txt");//相对路径，相对当前项目的根目录
        System.out.println(f2.getName());
    }

    /**
        public String getPath() ：将此File转换为路径名字符串。
        获取的构造方法中传递的路径

        toString方法调用的就是getPath方法
        源码:
            public String toString() {
                return getPath();
            }
     */
    private static void getPathMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code";
        File f1=new File(path);
        System.out.println(f1.getPath());
        File f2=new File("a.txt");//相对路径，相对当前项目的根目录
        System.out.println(f2.getPath());
    }

    /**
     * public String getAbsolutePath() ：返回此File的绝对路径名字符串。
     获取的构造方法中传递的路径
     无论路径是绝对的还是相对的,getAbsolutePath方法返回的都是绝对路径
     */
    private static void getAbsolutePathMethod() {
        String path = "F:\\learn\\java-all\\javase\\basic-code";
        File f1=new File(path);//绝对路径
        System.out.println(f1.getAbsolutePath());
        File f2=new File("a.txt");//相对路径，相对当前项目的根目录
        System.out.println(f2.getAbsolutePath());
    }
}
