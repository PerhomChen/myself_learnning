package JavaBasic04;

import java.io.File;
import java.io.IOException;

public class J124TestFile {
    public static void main(String[] args) {

        //代表文件
        File f = new File("E:\\programming software\\Dec-C++项目\\Untitled2.c");
        //代表目录
        File f1 = new File("E:\\programming software\\Dec-C++项目");

        //代表父目录下的子文件
        File f2 = new File(f1,"Project1.layout");

        /**
         * 一些常用的方法
         */

        if (f2.isFile())
        {
            System.out.println("是一个文件！");
        }
        if(f1.isDirectory())
            System.out.println("是一个目录！");

        //创建文件
        File f3 = new File(f1,"File44.java");
        /*try {
            f3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //删除文件
        f3.delete();
        //创建目录
        File f4 = new File(f1,"aa/bb/cc/dd ");
        //创建多个嵌套新目录
        f4.mkdirs();
        //创造直接目录
        f4.mkdir();



    }
}

/**
 * 打印目录树
 */

class TestFileTree{
    public static void main(String[] args) {
        File f = new File("E:\\programming software\\Dec-C++项目");
        printFile(f,0);
    }

    /**
     * 一个牛批的算法
     * @param f
     * @param level
     */
    public static void printFile(File f ,int level){
        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(f.getName());

        if(f.isDirectory()){
            File[] file = f.listFiles();
            for(File temp :file){
                printFile(temp,level+1);
            }
        }
    }

}