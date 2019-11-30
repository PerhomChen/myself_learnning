package Test;

public class Test01 {
    public static void main(String[] args) {

        StringBuffer a, b, c;
        a = new StringBuffer("test");
        b = a;
        c = b;
        String processA = processA(a);
        String processB = processB(b);
        String processC = processC(c);
        System.out.println(processA);
        System.out.println(processB);
        System.out.println(processC);
    }

    static String processA(StringBuffer str){
        return str.append("A").toString();
    }

    static String processB(StringBuffer str){
        return str.append("B").toString();
    }

    static String processC(StringBuffer str){
        return str.append("C").toString();
    }


}
