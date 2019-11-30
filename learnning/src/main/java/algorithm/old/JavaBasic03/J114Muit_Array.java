package JavaBasic03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class J114Muit_Array {
    /**
     * 打印多维数组
     * @param c
     */
    public static void printMuit_Array(int [][] c){
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c.length;j++){
                System.out.print(c[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 矩阵的相加运算
     * @param
     */
    public static int[][] add(int[][] a,int [][] b){
        int [][] c = new int[a.length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                c[i][j] = a[i][j] +b[i][j];
            }
        }
        return c;
    }
    public static void main(String[] args) {
        int [][] a = new int[][]{
                 {2,3,5},
                 {4,5,28},
                {3,1,98}
        };

        int [][] b = new int[][]{
                {2,4,34},
                {1,8,65},
                {8,5,67}

        };
        int [][] c = add(a,b);
        printMuit_Array(c);

        /**
         * 数组的拷贝
         */
        String[] s = {"kjk","微软","period","oracle","哼哼哼"};
        String [] jj = new String [6];
        System.arraycopy(s,0,jj,0,s.length);
        for(String i:jj){
            System.out.println(i);
        }

        /**
         * 打印数组
         */

        System.out.println(Arrays.toString(jj));

        /**
         * 数组排序
         */
        int [] jk ={1,423,24,2332,54,21};
        Arrays.sort(jk);
        System.out.println(Arrays.toString(jk));

        /**
         * 数组的填充:把2到4的元素替换为100
         */
        Arrays.fill(jk,2,4,100);
        System.out.println(Arrays.toString(jk));

    }
}
