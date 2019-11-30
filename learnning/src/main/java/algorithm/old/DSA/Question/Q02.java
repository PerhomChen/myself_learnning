package DSA.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，求出它的所有子集
 */
public class Q02 {

    public List<List<Integer>> getchildCollection (int [] a){
        List<List<Integer>> ret = new ArrayList<>();
        //加入空集

        List<Integer> list= new ArrayList<Integer>();
        ret.add(list);
        //总共遍历的次数
        long sub = (long)Math.pow(2,a.length);
        //进行位运算
        int hash =1;
        //loop

        while(hash<sub){
            int k = 0;
            List<Integer> temp =new ArrayList<Integer>();
            for(int i=1;i<=sub;i=i<<1){
                if((i&hash)!=0){
                    temp.add(a[k]);

                }

                k++;
            }
            ret.add(temp);
            hash++;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] a1 = {1,3,4,5};

         Q02 cc = new Q02();
        List<List<Integer>> list2 = cc.getchildCollection(a1);
        for(List<Integer> l:list2){

            for(int ii:l){
                System.out.print(ii+"\t");
            }
            System.out.println();
        }

    }
}
