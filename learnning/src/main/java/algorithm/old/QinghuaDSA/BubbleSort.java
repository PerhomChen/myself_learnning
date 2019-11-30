package QinghuaDSA;

/**
 * 冒泡排序
 */
public class BubbleSort {

    static int count = 0;
    public int[] bubbleSort(int [] a){


        int n = a.length;
        for(boolean sorted = false;sorted =!sorted;n--){
            for(int i=1;i<n;i++){
                if(a[i-1]>a[i]){
                    //交换
                    int b = a[i-1];
                    a [i-1] = a[i];
                    a[i] = b;

                    count++;
                    sorted = false;
                }
            }
            if(sorted ==true){
                return a;
            }
        }
        return a;
    }


    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();
        int [] a = {1,2,43,23,32,56,23,56,9,5,8,74};
        int [] b =  bs.bubbleSort(a);
        for(int c :b)
            System.out.print(c+"\t");
        System.out.println();
        System.out.println(count);

    }

}
