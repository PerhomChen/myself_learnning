package DSA.Query;

import DSA.SortAlgorithm.QuickSort;

public class BinartSearch {
    /**
     * 二分查找，输入的数组必须是排好序的。
     * 时间复杂度：O(log2 n)
     * @param a
     * @param value
     * @return
     */
    public int getValue(int [] a,int value){
        int ret=-1;
        int low =0 ;
        int high = a.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]==value){
                return value;

            }
            if(a[mid]<value){
                low = mid+1;
            }
            if(a[mid]>value)
            {
                high = mid-1;
                System.out.println(high);
            }

        }

        return ret;

    }

    public static void main(String[] args) {
        BinartSearch bs = new BinartSearch();
        int [] a = {2,3,5,6,8,12,54,76,34,765,43,22,90};
        QuickSort quickSort = new QuickSort();
        a = quickSort.quickSort(a,0,a.length-1);
        for(int ii : a){
            System.out.print(ii+"\t");
        }
        int b = bs.getValue(a,8);
        System.out.println();
        System.out.println(b);
    }
}
