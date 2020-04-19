package com.ysdrzp.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {6,5,3,7,8,1,2,0,4,9};
        insertionSort(a, a.length);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    /**
     * 插入排序，a表示数组，n表示数组大小
     * @param a
     * @param n
     */
    private static void insertionSort(int[] a, int n){

        if (n <= 1)
            return;

        for (int i = 1; i < n; i++){// 取出一个元素
            int val = a[i];

            // 找到元素的位置
            int j = i - 1;
            for (; j >= 0; j--){
                if (a[j] > val){
                    // 数据移动
                    a[j + 1] = a[j];
                }else {
                   break;
                }
            }
            // 插入元素
            a[j + 1] = val;
        }
    }

}
