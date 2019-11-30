package DSA.SortAlgorithm;

/**
 * 快速排序
 */
public class QuickSort {

    //交换的次数
    static int count = 0;
    /**
     * 递归部分
     * @param a
     * @param low
     * @param high
     * @return
     */
    public int[] quickSort(int [] a ,int low,int high){

        if(low<high) {
            int povit = partition(a, low, high);
            quickSort(a, low, povit - 1);
            quickSort(a, povit + 1, high);
        }

        return a;
    }
    public  int partition(int [] a,int low,int high){
        int pi = a[high];

        int temp;
        int left = low-1 ;

        for(int j =low;j<high;j++){

            if(a[j]<=pi){

                left++;
                //加判断防止交换相同元素
                 temp = a[left];
                 a[left] = a[j];
                 a[j] = temp;
                 count ++;


            }
        }
        a[high] = a[left+1];
        a[left+1] = pi;

        return (left+1);
    }

    public static void main(String[] args) {
        int [] a ={12,4,67,59,343,53,3223,54,10,63,32,23,63,48,75,62,73,65,90,84};
        for(int b:a)
            System.out.print(b+"\t");

        System.out.println();
        QuickSort qs = new QuickSort();
        a = qs.quickSort(a,0,a.length-1);
        for(int b:a)
            System.out.print(b+"\t");
        System.out.println();
        System.out.println(count);
    }
}
