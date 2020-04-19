package com.ysdrzp.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {6,5,3,7,8,1,2,0,4,9};
        bubbleSort(a, a.length);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    /**
     * 冒泡排序，a表示数组，n表示数组大小
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {// 冒泡的次数
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {// 比较的次数
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

}
