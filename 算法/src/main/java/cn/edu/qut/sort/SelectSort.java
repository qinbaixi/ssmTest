package cn.edu.qut.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {9,35,2,2,2,2,5,4};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序，将第一个默认为最小，向后遍历，遇到比它小的交换位置，minIndex记录遍历的数当前最小的下标
     * @param a
     */
    public static void selectSort(int[] a) {
        //遍历所有的数
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            //往后遍历，找到后面最小的一个，将minIdex指向他
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex=j;
                }
            }
            //交换
            if (i != minIndex) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i]=temp;
            }

        }
    }
}



