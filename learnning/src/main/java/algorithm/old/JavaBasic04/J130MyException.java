package JavaBasic04;


public class J130MyException extends Exception {

    public J130MyException(){

    }
      public J130MyException(String message) {
        super(message);
    }
}

class Test01 {
    //抛出自定义的异常类使用throws
    void test02 ()throws J130MyException{

    }
    public static void main(String[] args) {
        Test01 t = new Test01();
        try {
            t.test02();
        } catch (J130MyException e) {
            e.printStackTrace();
        }

    }
}