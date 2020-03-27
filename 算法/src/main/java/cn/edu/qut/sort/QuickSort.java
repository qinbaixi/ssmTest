package cn.edu.qut.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,97,9,8,7,6,5,4};
        System.out.println(Arrays.toString(arr));
        quickSork(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序，后面的参数是为了方便递归使用，使用第一个为基准，小于的放一边，大于大的放一边，进行递归
     * @param arr
     * @param start 起始位置
     * @param end   结束位置
     */
    public static void quickSork(int[] arr, int start, int end) {

        if (start < end) {

            int sign = arr[start];
            int low = start;
            int height = end;

            while (low < height) {
                //右边的数据大就pass
                while (low<height&&arr[height] >= sign) {
                    height--;
                }
                //找第一个比sign小的交换
                arr[low] = arr[height];
                //左边的数据小就pass
                while (low<height&&arr[low] <= sign) {
                    low++;
                }
                //找到第一个大的交换
                arr[height] = arr[low];
            }
            arr[low] = sign;
            quickSork(arr, start, low);
            quickSork(arr, low + 1, end);
        }
    }
}

