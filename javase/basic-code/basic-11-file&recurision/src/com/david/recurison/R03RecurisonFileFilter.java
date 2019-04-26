package com.david.recurison;
import java.io.File;
import java.io.FileFilter;

/**
 * @author david
 * @create 2019-04-20 18:04
 */
public class R03RecurisonFileFilter {
    public static void main(String[] args) {
        File dir =new File("D:\\BaiduNetdiskDownload\\黑马java57期");
        //getFilesByfileFilter(dir);

        getFilesByfileFilterLambda(dir);
    }

    /**
     * lambda方式实现过滤器，遍历找出.avi的文件
     * @param dir
     */
    private static void getFilesByfileFilterLambda(File dir) {
        File[] files = dir.listFiles((File f) ->{
            if(f.isDirectory()) return true;
            return f.getName().toLowerCase().endsWith(".avi");
        });
        for (File file : files) {
            if(file.isDirectory()){
                getFilesByfileFilterLambda(file);
            }else{
                System.out.println(file);
            }
        }
    }

    /**
     * 实现接口的方式过滤 找出mp4类型文件
     * @param dir
     */
    private static void getFilesByfileFilter(File dir) {
        //System.out.println(dir);
        File[] files = dir.listFiles(new FileFilterImpl());
        for (File file : files) {
            if(file.isDirectory()){
                getFilesByfileFilter(file);
            }else{
                System.out.println(file);
            }
        }


    }
}
class FileFilterImpl implements FileFilter{
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()) return true;
        return pathname.getName().toLowerCase().endsWith(".mp4");
    }
}