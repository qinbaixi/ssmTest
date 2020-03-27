package cn.edu.qut.hanoi;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(10,'A','B','C');
    }

    /**
     * hanoi问题,递归问题
     * @param n 层数
     * @param from 移动的盘子所在地
     * @param in   移动的盘子中间
     * @param to   移动的盘子目的地
     */
    public static void hanoi(int n,char from,char in ,char to){
        if (n == 1) {
            //只剩一个盘子的情况，将所有盘子视为第n个和剩下的n-1个，以下统称n和n-1；
            System.out.println("将"+n+"从"+from+"移动到"+to);
        }else {
          //将n-1个盘子移动到中间，即in变为目的
            hanoi(n-1,from,to,in);
            System.out.println("将"+n+"从"+from+"移动到"+to);
            //将n-1个盘子移到目的to
            hanoi(n-1,in,from,to);
        }

    }

}
