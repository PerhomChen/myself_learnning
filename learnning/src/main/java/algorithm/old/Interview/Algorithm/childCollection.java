package Interview.Algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class childCollection {
    //
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

       childCollection cc = new childCollection();
       List<List<Integer>> list2 = cc.getchildCollection(a1);
       for(List<Integer> l:list2){

        for(int ii:l){
            System.out.print(ii+"\t");
        }
           System.out.println();
        }

    }
}

class jj {
    class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }
}