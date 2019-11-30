package DSA.SortAlgorithm;

public class BubbleSort {

    public int[] bubbleSort(int [] a){
        int count =0;
        int n = a.length;
        //交换存储的变量temp，存储每次最小值的变量post
        int temp;
/*n次过后，它一定能排好，不用判断*/
        for(boolean sorted = false;sorted =!sorted;n--){

            //j=0,循环到j=n-1，j+1发生数组越界异常
            for( int j=1;j<n;j++){
                if(a[j-1]>a[j]){
                    count++;
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    sorted = false;
                }
            }
            if(sorted ==true){
                System.out.println(count);
                return a;
            }

        }

        return a;
    }

    public static void main(String[] args) {
        int [] a ={12,4,2,5,343,53,3223,54,12,63,32,23,63,8,75,2,73,65};
        BubbleSort bs = new BubbleSort();
        a = bs.bubbleSort(a);
        for(int b:a)
            System.out.print(b+"\t");
    }
}
