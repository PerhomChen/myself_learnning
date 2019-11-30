package JavaBasic04;

import java.util.HashMap;
import java.util.Map;

public class J137TestMap {

    public static void main(String[] args) {
        Map map = new HashMap();
        //放
        map.put("陈培鸿",new Wife("迪丽热巴"));
        map.put("王宝强","马蓉");

        //取
        Wife wife = (Wife)map.get("陈培鸿");
        System.out.println(wife.getName());
        //包含这个key
        Boolean bolean = map.containsKey("王宝强");

        //包含这个value

        Boolean bolean1 = map.containsValue("马蓉");
        System.out.println(bolean);
        System.out.println(bolean1);



    }
}

class Wife{
    String name;

    Wife(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
}