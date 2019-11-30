package JavaBaisc;

import JavaBasicday02.J44TestEncapsulation;

class TestProtected extends J44TestEncapsulation{
    public void jkjk(){
        super.jkj();
    }
    public static void main(String[] args){

     TestProtected jk = new TestProtected();
     jk.jkj();

    //'jkj()' has private access in 'JavaBasicday02.J44TestEncapsulation

    }

}
