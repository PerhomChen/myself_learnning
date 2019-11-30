package DSA.Question;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个整型数组，求它们的交集
 * 思路：先对其中一个进行快排，然后遍历乱序的，对排好序的进行二分查找。
 */
public class Q01 {
    /**
     * 快速排序
     * @param a
     * @param low
     * @param high
     * @return
     */
    public int [] quickSort(int [] a,int low,int high){

        if(low<high){
            int povit =partition(a,low,high);
            quickSort(a,low,povit-1);
            quickSort(a,povit+1,high);
        }
        return a;
    }

    public int partition (int [] a,int low,int high){
        //找一个标志值
        int pi = a[high];
        //临时存储
        int temp;
        int left = low-1;
        for(int i=low;i<high;i++){

            if(a[i]<=pi){
                left++;
                //交换

                    temp = a[i];
                    a[i] = a[left];
                    a[i] = temp;

            }

        }
        a[high] = a[left+1];
        a[left+1] = pi;

        return (left+1);
    }

    public int binarySearch(int [] a,int value){
        int ret = -1;
        int temp;
        int high = a.length-1;
        int low = 0;
        int mid;
        while (low<=high){

            mid =(low+high)/2;
            if(a[mid]==value)
                return value;
            if(a[mid]<value)
                low = mid+1;
            if(a[mid]>value)
                high = mid -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] a = {2,3,4,1,5,6,5,4,20,8,6967,976,43,2387,56,32};
        int [] b = {5,3,17,533,861,21,65,97,90,20};
        Set<Integer> set = new HashSet();
        Q01 q01 = new Q01();
       a=  q01.quickSort(a,0,a.length-1);
       for(int ii : a){
           System.out.print(ii+"\t");
       }
        System.out.println();

       for(int i=0;i<b.length;i++){
           int aa = q01.binarySearch(a,b[i]);
           if(aa!=-1){
               set.add(aa);
           }

       }

       for(Integer i :set){
           System.out.print(i+"\t");
       }
    }
}
