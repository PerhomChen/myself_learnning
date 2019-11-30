package Interview.JavaBasic;

public class TestString01 {
    public static void main(String[] args) {
        String str1 = "aa";
        System.out.println(str1.hashCode());
        str1 += "bbb";
        String str = str1;
        System.out.println(str1.hashCode());
        str1 +="ccc";
        System.out.println(str1.hashCode());
        System.out.println(str1==str);
        System.out.println(str1);
        String str2 = "aabbbccc";
        System.out.println(str1==str2);

        String str3 ="aa";
        String str4 = new String("aa");
        String str5 = new String("aa");
        System.out.println(str4==str5);
    }
}
