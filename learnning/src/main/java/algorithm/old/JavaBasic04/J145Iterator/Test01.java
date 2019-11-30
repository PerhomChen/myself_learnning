package JavaBasic04.J145Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Test01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        // Use for loop traversing the list.

        for(int i=0;i<list.size();i++){

            System.out.println( list.get(i));
        }

        System.out.println("########################");
        //Use Iterator traversing the list.

        for( Iterator iterator = list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }

        System.out.println("########################");

        HashSet hashSet =  new HashSet();
        hashSet.add("告警");
        hashSet.add("jkj");
        hashSet.add("kll");



        //use for Iterator traversing the set
        //because set is non-repeatable;
        for(Iterator iterator = hashSet.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }

    }
}
