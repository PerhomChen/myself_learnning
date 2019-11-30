package DSA.Query;

import DSA.SortAlgorithm.QuickSort;

/**
 * 插值查询是在二分查找的基础上进行优化的，适合表很长，值分布比较均匀的系列。
 * 时间复杂度：O(log2(log2 n))
 *
 * --遇到的问题：递归return的问题
 *    --return跳出本次循环。
 */
public class InsertValueSearch {
    public int insertValuerSearch(int [] a,int value,int low ,int high){
        int ret =-99;
        int mid = low+(value-a[low])*(high-low)/(a[high]-a[low]);

        if(a[mid]==value)
        {
            return mid;
        }
        if(a[mid]<value)
           return insertValuerSearch(a,value,mid+1,high);
        if(a[mid]>value)
         insertValuerSearch(a,value,low,mid-1);


        return ret;
    }

    public static void main(String[] args) {
        int [] a = {2,3,5,6,8,12,47,34,25,22,40};
        InsertValueSearch ivs =  new InsertValueSearch();
        QuickSort quickSort = new QuickSort();
        a = quickSort.quickSort(a,0,a.length-1);
        for(int ii :a){
            System.out.print(ii+"\t");
        }

       int aa = ivs.insertValuerSearch(a,8,0,a.length-1);
        System.out.println(aa);
    }
}
