package JavaBasic04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class J128TestException {
    public static void main(String[] args) {
        /**
         * 一个try可以对应多个catch
         */
        FileReader reader =null;
        try {
            reader = new FileReader("E:\\编程\\Book\\剑指offer第二版/a.txt");
                char c =(char)reader.read();
                System.out.println(c);
        }
        /**
         * catch的异常捕获顺序不能交换。
         * 如果异常之间有继承关系，在顺序安排上需注意，越是顶层的类，
         * 越放在下面，再不然就直接把多余的catch省略掉。
         */
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
             catch (IOException e) {
                e.printStackTrace();
            }
            //finally关资源
        finally{
            //得在try语句块外面定义对象,并初始化

            try {
                //预防空指针异常的处理
                if(reader!=null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
