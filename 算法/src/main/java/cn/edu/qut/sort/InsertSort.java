package cn.edu.qut.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {9,35,777,2,5,4};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序，默认前面的数组已经排序，将遍历到的每一个数组插入到合适位置
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //从第二个元素开始
        for (int i = 1; i <arr.length ; i++) {
            //存挡圈遍历的数据
            int temp = arr[i];
            int j;
            //如果当前数据比上一个小，即比已经排序好的最大的还大
            if (arr[i]<arr[i-1]) {
                //找到排序好的位置 j
                for ( j = i - 1; j >= 0 && arr[j]>temp; j--) {
                    //往前挪一个位置，第一次进入是相当于arr[i-1]往后移了一个位置
                    arr[j + 1] = arr[j];
                }
                //
                arr[j+1]=temp;
            }
        }
    }
}
