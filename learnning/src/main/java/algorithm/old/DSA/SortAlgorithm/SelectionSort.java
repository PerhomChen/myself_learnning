package DSA.SortAlgorithm;

/**
 * 选择排序
 */
public class SelectionSort {

    public int[] selectionSort(int [] a){
        int count = 0;
        int n = a.length;
        //交换存储的变量temp，存储每次最小值的变量post
        int temp;int pos =0;

        for(int i=0;i<n-1;i++){
            pos = i;
            for( int j=i+1;j<n;j++){
                if(a[j]<a[pos]){
                    pos = j;
                }
            }
            if(pos!=i){
                temp = a[pos];
                a[pos] = a[i];
                a[i] = temp;
                count ++;
            }
        }
        System.out.println(count);

        return a;
    }

    public static void main(String[] args) {
        int [] a ={12,4,2,5,343,53,3223,54,12,63,32,23,63,8,75,2,73,65};
        SelectionSort ss = new SelectionSort();
        a = ss.selectionSort(a);
        for(int b:a)
        System.out.print(b+"\t");
    }

}
