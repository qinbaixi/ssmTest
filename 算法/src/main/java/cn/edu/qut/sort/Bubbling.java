package cn.edu.qut.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Bubbling {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4};
        System.out.println(Arrays.toString(arr));
       bubbling(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序,此次两两比较
     * @param arr
     */
    public static void bubbling(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j+1];
                    arr[j + 1] = arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
