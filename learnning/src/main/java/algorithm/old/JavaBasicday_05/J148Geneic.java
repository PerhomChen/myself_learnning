package JavaBasicday_05;

import JavaBasicday_05.testGeneic.Student;

public class J148Geneic {

    public static void main(String[] args) {

        //int----->integer ----> Object（多态的应用）
        Student student = new Student(80,90);
        Object object = 80;
        int score1 = (int)object;  //Object ---> Integer ----> 自动拆箱（多态的应用）
        String str = null;
       if(student.getMysqlScore() instanceof String){
           str = (String) student.getMysqlScore();
       }

        System.out.println(student.getJavaScore()+";"+str);
    }

}
