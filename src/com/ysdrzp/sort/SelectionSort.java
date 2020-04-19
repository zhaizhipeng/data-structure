package com.ysdrzp.sort;

/**
 * 选择排序算法
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {6,5,3,7,8,1,2,0,4,9};
        selectionSort(a, a.length);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    /**
     * 选择排序：a表示数组，n表示数组大小
     * @param a
     * @param n
     */
    private static void selectionSort(int[] a, int n){

        for (int i = 0; i < n - 1; i++){// 选择的次数

            int min = i;
            // 找出最小的元素
            for (int j = i + 1; j < n; j++){
                if (a[j] < a[min])
                    min = j; // 记录最小元素的索引
            }

            if (min != i){// 交换元素
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

}
