package JavaBasic04.J140MyHashMap;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("王宝强",new Wife("马蓉"));

        myHashMap.put("陈培鸿",new Wife("迪丽热巴"));
        Wife wife = (Wife) myHashMap.getValue("陈培鸿");
        Wife wife1 = (Wife) myHashMap.getValue("王宝强");
        System.out.println(wife.getName());
        System.out.println(wife1.getName());
        myHashMap.put("陈培鸿",new Wife("奥黛.丽赫本"));
        wife =(Wife) myHashMap.getValue("陈培鸿");
        System.out.println(wife.getName());


        HashMap map = new HashMap();
        map.put("陈培鸿",new Wife("迪丽热巴"));

    }
}
