package JavaBasic04.J140MyHashMap;

import JavaBasic04.J135MyLinkedList.MyList;
import JavaBasic04.J135MyLinkedList.Node;

import java.util.HashMap;

/**
 * 手写一个hashMap
 * HashMap的底层原理：数组+链表
 */
public class MyHashMap {
    private  Object[] hashMap;


    //构造器
    public MyHashMap(){
        hashMap = new Object[999];
    }

    //put方法
    //使用链表解决
    //key值不能重复
    public void put(Object key,Object value){
        mapObject mo = new mapObject(key, value);
        //对key对象求哈希再取余
        int i =key.hashCode()%hashMap.length;
        //如果数组里面为空，则添加链表，否则直接后面在原先链表后面加上。
        if(hashMap[i]==null){
            MyList list = new MyList();
            list.add(mo);
            hashMap[i] = list;
            /*Node node =  list.getFrist();
            mapObject mo1 = (mapObject) node.getObject();
            Wife wife = (Wife) mo1.getValue();
            System.out.println(wife.getName());*/

        }else{
            //实现比对相同key，覆盖value的值
            mapObject mo1 = (mapObject) getList(i,key);
            if(mo1==null){
                MyList list = (MyList) hashMap[i];
                list.add(mo);
            }else{
                mo1.setValue(value);
            }

         /*   Wife wife = (Wife) mo.getValue();
            System.out.println(wife.getName());*/
        }
    }

    //封装根据key遍历list的方法
    public Object getList(int i ,Object key){
        MyList list = (MyList) hashMap[i];
        //遍历比对key
        for(int a=0;a<list.size();a++){
            Node node = list.getFrist();
            mapObject mo =(mapObject) node.getObject();
            if(mo.getKey().equals(key)){

                return mo;
            }else{
                node = node.getNext();
            }

        }
        return null;
    }



    //get方法
    //根据key取value
    public Object getValue(Object key){
        //根据key求hashcode
        int i = key.hashCode()%999;
        //如果该位置不为null
        if(hashMap[i]!=null){
            mapObject mo =(mapObject) getList(i,key);
            return mo.getValue();
        }
        return -1;
    }





}
