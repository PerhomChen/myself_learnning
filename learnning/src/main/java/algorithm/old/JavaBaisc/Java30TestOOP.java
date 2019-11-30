package JavaBaisc;

public class Java30TestOOP {
    //静态的数据
     String name;
     int id;
     int age;
     int weight;
     Java32TestOOP01 computer;

    //动态的行为
    public void study(){
       System.out.println(name+"正在努力学习");
    }

    public void sayGoodbye(String sname){

        System.out.println(name+"向"+sname+"说goodbye");
    }


}
