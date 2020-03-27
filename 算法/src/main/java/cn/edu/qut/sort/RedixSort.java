package cn.edu.qut.sort;

import java.util.Arrays;

/**
 * 有10个数组设为0-9；
 * 第一次按个位数对应放入，然后从第0个数组按顺序取出,先进先出
 * 第二次按照十位数对应放入，然后从第0个数组顺序取出
 * 以此循环
 * 这就是基数排序
 */
public class RedixSort {
    public static void main(String[] args) {
        int[] a = {5, 33, 48, 789, 745, 645, 21, 31, 4, 22};
        redixSort(a);
        System.out.println(Arrays.toString(a));

    }

    public static void redixSort(int[] a) {
        //存最数组中最大的数字
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        //获取循环次数
        int maxLength = (max + "").length();
        //用于临时存储数据的数组,a.length标识所有的数据都是同一类型，即都是统一基数级别的
        int[][] temp = new int[10][a.length];
        //用于记录在temp中相应的数组中存放的数字的数量
        int[] counts = new int[10];
        //根据最大长度的数决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把每一个数字分别计算余数
            for (int j = 0; j < a.length; j++) {
                //计算余数
                int ys = a[j] / n % 10;
                //把当前遍历的数据放入指定的数组中
                temp[ys][counts[ys]] = a[j];
                //记录数量
                counts[ys]++;
            }
            //记录取的元素需要放的位置
            int index=0;
            //把数字取出来
            for(int k=0;k<counts.length;k++) {
                //记录数量的数组中当前余数记录的数量不为0
                if(counts[k]!=0) {
                    //循环取出元素
                    for(int l=0;l<counts[k];l++) {
                        //取出元素
                        a[index] = temp[k][l];
                        //记录下一个位置
                        index++;
                    }
                    //把数量置为0
                    counts[k]=0;
                }
            }
        }

    }
}
