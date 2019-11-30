package JavaBasic04;

public class J133MyArrayList {

    private Object[] elements;
    private int size;

    //构造器
    public J133MyArrayList(){

        this(10);
    }
    public J133MyArrayList(int size){
        elements = new Object[size];
    }

    //add方法

    public void add(Object obj){
        //判断是否需要扩容
        checkLong();
        elements [size++] = obj;
    }

    //封装扩容方法
    public void checkLong(){
        if(size==elements.length){
            Object [] newelements  = new Object[(size+1)<<1];
            System.arraycopy(elements,0,newelements,0,elements.length);
            elements = newelements;
        }

    }
    //返回size
    public int size(){
        return size;
    }

    //remove方法
    public void remove(int index){
        //判断索引是否越界
        if(checkIndex(index)){
            Object [] newelements  = new Object[elements.length];
            System.arraycopy(elements,0,newelements,0,index);
            System.arraycopy(elements,index+1,newelements,index,size-index-1);
            elements = newelements;
            size--;
        }

    }

    //往指定位置插入元素
    public void insert(int index ,Object obj){
        //检查长度
        checkLong();
        Object [] newelements  = new Object[elements.length];
        System.arraycopy(elements,0,newelements,0,index);
        newelements[index] = obj;
        System.arraycopy(elements,index,newelements,index+1,size-index-1);
        elements = newelements;
        size++;
    }

    public boolean checkIndex (int index){
        if(index>=0&&index<size){
            return true;
        }
        return false;
    }
    //get方法
    public Object get(int index){
        if(checkIndex(index)){

            return elements[index];
        }
        return null;
    }

    public static void main(String[] args) {
        J133MyArrayList ml = new J133MyArrayList();
        ml.add("jklj");
        ml.add("aaaa");
        System.out.println(ml.size());

        ml.add("bknm");
        System.out.println(ml.get(1));
        System.out.println(ml.size());
        ml.remove(1);
        System.out.println(ml.get(1));
        System.out.println(ml.size());
        System.out.println("*******************");
        ml.add("jjjjj");
        ml.add("kkkkkk");
        System.out.println(ml.size());
        System.out.println(ml.get(2));
        ml.insert(2,"hhhhh");
        System.out.println(ml.size());
        System.out.println(ml.get(2));

        ml.remove(1);
        System.out.println(ml.get(1));

    }
}
