package JavaBasic04;

public class J118Testauto {
    public static void main(String[] args) {
       /* JDK5.0之后  自动装箱
        编译器帮我们改进代码，Integer a = new Integer（1000）
        */
        Integer a = 1000;
        /**
         * 自动拆箱
         * 编译器改进：new Integer(1500).intValue();
         *当Integer和int类型数值进行比较的时候，Ineger会自动拆箱为int再比较。1
         */

        int c = new Integer("64473");
        System.out.println(c);

        /**
         *[-128--127]之间的数，仍然会被当做基本数据类型来处理。
         * 提高效率。
         */
        Integer a1 = 1204;
        Integer a2 = 1204;
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));

        System.out.println("################!");

        Integer a3 = 124;
        Integer a4 = 124;
        System.out.println(a3==a4);
        System.out.println(a3.equals(a4));

    }
}
