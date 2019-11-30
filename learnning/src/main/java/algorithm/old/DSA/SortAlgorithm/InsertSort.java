package DSA.SortAlgorithm;

/**
 * 插入排序
 */
public class InsertSort {
    public int[] insertSort(int [] a){
        //发生交换的次数
        int count = 0;
        int n = a.length;
        //交换存储的变量temp，存储每次最小值的变量post
        int temp;int pos =0;

        for(int i=1;i<n;i++){

            for( int j=i;j>0;j--){

                if(a[j-1]>a[j]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    count ++;
                }
            }

        }
        System.out.println(count);

        return a;
    }

    public static void main(String[] args) {
        int [] a ={12,4,67,59,343,53,3223,54,10,63,32,23,63,48,75,62,73,65};
        InsertSort is = new InsertSort();
        a = is.insertSort(a);
        for(int b:a)
            System.out.print(b+"\t");
    }
}
