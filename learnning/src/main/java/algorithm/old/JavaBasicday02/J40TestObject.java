package JavaBasicday02;

public  class J40TestObject {
    public static void main(String[] args){
        final int MAX_VALUE = 2555;

        Object as = new Object();
        System.out.println(as.toString());
        Object asd =new Object();
        System.out.println(asd.toString());
        System.out.println(asd.equals(as));
        System.out.println("########################");
    }
     public final void Testjhj(){

     }



}

class Testfinal extends J40TestObject{
//    public void Testjhj(){}
    //'Testjhj()' cannot override 'Testjhj()' in 'JavaBasicday02.J40TestObject';
   // overridden method is final
    public static void main(String [] args){

    }

}
