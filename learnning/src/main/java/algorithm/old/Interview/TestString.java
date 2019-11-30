package Interview;

import java.util.HashSet;

public class TestString {
    public static void main(String[] args){
        HashSet<String> hs=new HashSet<String>();
        String sb1=new String("aaabbb");
        String sb2=new String("aaabbb");
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}

        System.out.println(sb1.equals(sb2));
       // StringBuffer sb3=sb1;
       // sb1.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println(hs);
        System.out.println(hs.size());
    }

}
