package JavaBasic03;

import java.util.ArrayList;
/*静态导入*/
import static java.lang.Math.PI;
/**
 * 模拟实现JDK实现的ArrayList类
 */
public class J59Collection {
    /**
     * The value is used for Object storage.
     */
    Object[] value;

    /**
     * The id of the encoding used to encode the bytes in {@code value}.
     */
    private byte coder;

    /**
     * The size is the number of Objects used.
     */
    //数字属性成员变量默认初始化为0
    private int size;



   /* //两种构造器*/
    public J59Collection(){

     this(16);
        // ---这个构造器调用另一个构造器

    }
    public J59Collection(int size){
        if(size<0){
            throw new IllegalArgumentException("Illegal Capacity: "+
                    size);
        }
        else
        value = new Object[size];

    }

    public void add(Object obj){
        value[size] = obj;
        size ++;
        //扩容
        if(size>=value.length){
            int newCapacity = value.length<<1+2;
            Object newList [] = new Object[newCapacity];
            //可以使用System.arraycopy(src,srcPos,dest,destPos,length);
            for(int i=0;i<value.length;i++){
                newList[i] = value[i];
            }
            value = newList;


        }
    }



    public Object get(int index){
        if(index<0||index>size-1){
            try {  //手动抛出异常
                    throw new Exception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            return value[index];


    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        J59Collection a1 = new J59Collection(2);
        a1.add("aa");
        a1.add(new Human("高斯"));
        a1.add(new Human("高ee"));
        Human h = (Human)a1.get(1);
        System.out.println(h.getName());
        System.out.println(a1.get(2));
        System.out.println(a1.getSize());


        }


}

class Human extends superStatic{
    private String name;

    public Human(String name) {
        System.out.println("构造方法！");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static{
        System.out.println("子类的初始化块！");
    }

}

class testStatic {
    public static void main(String[] args) {
        Human h = new Human("perform");

    }
}


class superStatic {
    public superStatic() {
        System.out.println("父类的构造方法！");
    }
    //父类的静态初始化块
    static{
        System.out.println("父类的初始化块！");

    }
}
