package DSA.SortAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最大堆排序
 *
 */
public class HeapSort {
    public int[] buildHead(int [] a){
        //find last parent node

        for(int i=(a.length-2)/2;i>=0;i--){
            adjustHeap(a,i,a.length);

        }
        return a;
    }
    public int[] adjustHeap(int []a,int f,int length){

      //存储父节点
        int temp = a[f];
        for(int i=f*2+1;i<length;i=i*2+1) {//从i结点的左子结点开始，也就是2i+1处开始
            //判断右节点有没有并且 //左小于右，指向右边
            if ((i+1<= length-1) && (a[i] < a[i + 1])) {
                i++;
            }
            if (a[i] > temp) {
                //直接赋值给父节点(把最大值直接赋值)
                a[f]= a[i];
                //记录扫描到的最大值的索引
                f = i;
            }
        }
        a[f] = temp;
        return a;
    }

    public static void adjustHeap1(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){
                //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int [] a ={12,4,67,59,343,53,3223,54,10,63,32,23,63,48,75,62,73,65,90,84};
        //create heap大顶堆;
        hs.buildHead(a);
        //temp
        System.out.println(Arrays.toString(a));
        int temp =0;
        for(int i=a.length-1;i>0;i--){
            temp = a[i];
            a[i] = a [0];
            a[0] = temp;
            hs.adjustHeap(a,0,i);
        }
        System.out.println();
        System.out.println(Arrays.toString(a));
    }
}
