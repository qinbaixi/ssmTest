package cn.edu.qut.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 785, 666, 221, 4, 347, 85};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 对步长大于等于0的分组每次进行快速排序,步长每次减半
     * @param a
     */
    public static void shellSort(int[] a) {
        //遍历步长步长等于1时结束
        for (int d = a.length/2;d>0 ;d/=2 ) {
            //遍历所有的元素
            for (int i = d; i < a.length; i++) {
             //遍历本组所有的元素
                for (int j = i - d; j >= 0; j-=d) {
                    //开始快速排序
                    if (a[j] > a[j + d]) {
                        int temp = a[j];
                        a[j] = a[j+d];
                        a[j+d]=temp;
                    }
                }
            }
        }
    }
}
