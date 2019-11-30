package DSA.SortAlgorithm;

import java.util.Arrays;

/**
 * 归并排序
 * 一般用于两个已经排好序的数组合并成一个有序的数组
 */
public class MergeSort {

    public void mergeSort (int []a,int start ,int end){

        if(start<end){
         int  mid = (start+end)/2;
             //分治
             mergeSort(a,start,mid);
             mergeSort(a,mid+1,end);
             //通过上面的递归，已经分为最小的单个单位，然后从最小的但各单位递归地单用合并方法
             merge(a,start,mid,end);
        }


    }

    /**
     * 合并
     * @param a
     * @param left
     * @param mid
     * @param right
     * @return
     */
    public void merge(int []a,int left ,int mid,int right){
        //定义一个临时存储数组
        int [] temp = new int[a.length];
        //p1指向左部分的第一个元素，p2执行右部分的第一个元素，k为临时数组的有序指针
        int p1 = left; int p2 = mid+1; int k = left;
        while(p1<=mid && p2<=right) {
            if (a[p1] <= a[p2])
                temp[k++] = a[p1++];
            else
                temp[k++] = a[p2++];
        }
            //收尾那些没有加入的比较大的元素，有可能是左部分，有可能是右部分
            while(p1<=mid)
                temp[k++] = a [p1++];
            while(p2<=right)
                temp[k++] = a [p2++];
            //把临时数组的值存回原数组中
            for(int i=left;i<=right;i++){
                a[i] = temp [i];
            }

    }

    public static void main(String[] args) {
        int [] a = {2,45,6,4,7,2,7,4,8,3,9,3};
        MergeSort ms = new MergeSort();
        ms.mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
