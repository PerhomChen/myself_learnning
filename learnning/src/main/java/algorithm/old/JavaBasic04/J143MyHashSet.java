package JavaBasic04;

import java.util.HashMap;
import java.util.HashSet;

/**
 * make a simple hashset
 */
public class J143MyHashSet {
    //hashset use HashMap to achieve;
    private HashMap map;
    //number of element in HashSet;
    private int size;
    // map's value Object;
    private static final Object PRESENT = new Object();

    public J143MyHashSet(){
        map = new HashMap();
    }

    //size method
    public int size(){
        return map.size();
    }

    //add method
    public void add(Object object){
        // The non-repeatable feature in the set uses the feature that the map's key
        //cannot be repeatable.
        map.put(object,PRESENT);
    }


    public static void main(String[] args) {
        J143MyHashSet mh = new J143MyHashSet();
        mh.add("aaaaa");
        mh.add("bbb");
        mh.add("bbb");
        System.out.println(mh.size());
    }


}
