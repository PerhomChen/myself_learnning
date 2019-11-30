package JavaBasic03;

public class J56StringBuild {
    char a2;

    public void outPutchar(){
        System.out.println(a2+"  ed");
        System.out.println(a2=='\u0000');
    }


    public static void main(String [] args) {
        //字符数组的初始长度是16
        StringBuilder str = new StringBuilder();
//        这时候字符数组的长度是5+16
        //字符数组的初始
        //字符数组为 ，value[] = {'d','f','d','s','d',\u0000,\u0000,...}
        StringBuilder str1 = new StringBuilder("dfdsd");
        //在dfdsd后面加上fdk
        //比16大后有确保容量的方法。--看源码
        str1.append("fdkf您从徐州不在线催眠，");
        str1.append(true).append("静静").append("开甲方开具");
        str1.delete(3,14);
        System.out.println(str1.reverse());
//        这时候字符数组的长度是32
        StringBuilder str2 = new StringBuilder(32);

        J56StringBuild dd = new J56StringBuild();
        dd.outPutchar();

         //一共产生两个对象
        StringBuilder stra = new StringBuilder('a');
        for(int i = 0;i<1000;i++){
            stra.append(i);
        }
        System.out.println(stra);

    }

}
