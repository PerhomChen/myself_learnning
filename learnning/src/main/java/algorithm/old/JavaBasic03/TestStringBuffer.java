package JavaBasic03;

public class TestStringBuffer {
    public static void changStringBuffer(StringBuffer ss1,StringBuffer ss2){
        ss1.append(" world");
        ss2 = ss1;
        System.out.println(ss1==ss2);
        System.out.println(ss1);
        System.out.println(ss2);

    }
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("Hello");
        StringBuffer s2 = new StringBuffer("Hello");
        System.out.println(s1==s2);
        changStringBuffer(s1,s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);

        s2 =s1;
        System.out.println(s1==s2);
    }
}
